package com.dengionline.gsg.api;

import com.dengionline.gsg.api.requests.ActionCheckRequest;
import com.dengionline.gsg.api.requests.ActionErrorsRequest;
import com.dengionline.gsg.api.requests.ActionMainBalanceRequest;
import com.dengionline.gsg.api.requests.ActionPayRequest;
import com.dengionline.gsg.api.requests.ActionPayStatusRequest;
import com.dengionline.gsg.api.requests.ActionPaySystemsRequest;
import com.dengionline.gsg.api.requests.CheckParams;
import com.dengionline.gsg.api.requests.PayParams;
import com.dengionline.gsg.api.requests.PayStatusParams;
import com.dengionline.gsg.api.responses.ActionCheckResponse;
import com.dengionline.gsg.api.responses.ActionErrorsResponse;
import com.dengionline.gsg.api.responses.ActionMainBalanceResponse;
import com.dengionline.gsg.api.responses.ActionPayResponse;
import com.dengionline.gsg.api.responses.ActionPayStatusResponse;
import com.dengionline.gsg.api.responses.ActionPaySystemsResponse;
import com.dengionline.gsg.api.responses.BasicResponse;
import com.dengionline.gsg.api.utils.JAXBFormater;
import com.ning.http.client.AsyncHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.HttpResponseBodyPart;
import com.ning.http.client.HttpResponseHeaders;
import com.ning.http.client.HttpResponseStatus;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;
import com.ning.http.client.extra.ThrottleRequestFilter;
import com.ning.http.client.providers.netty.NettyAsyncHttpProvider;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The ClientGSG class is a full feature abstraction on top of the GSG API
 * interface.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public class ClientGSG {

    // API base URL constant string
    private static final String defaultApiUrl = "https://gsg.dengionline.com/api";
    private static final String defaultApiUrlV2 = "https://paygate.dengionline.com/apiv2";
    private static final String apiFormat = "xml";
    private static final int defaultThreadLimit = 100;
    // HTTP status code
    private static final int HTTP_OK = 200;
    private static final int HTTP_CREATED = 201;
    private static final int HTTP_BAD_REQUEST = 400;
    private static final int HTTP_FORBIDDEN = 403;
    private static final int HTTP_NOT_FOUND = 404;
    // Async HTTP client
    private AsyncHttpClientConfig config;
    private AsyncHttpClient client;
    // API Url
    private String apiUrl;
    // Global data
    private Integer project;
    private String secret;

    /**
     * Versions GSG.
     */
    public static enum ApiVersion {

        /**
         * Version 1
         */
        version_1,
        /**
         * Version 1.x
         */
        version_1x
    }

    /**
     * Constructor
     *
     * @param project Client ID in the system GSG.
     * @param secret Secret key.
     */
    public ClientGSG(final Integer project, final String secret) {
        this(project, secret, ClientGSG.defaultApiUrl, ClientGSG.defaultThreadLimit);
    }

    /**
     * Constructor
     *
     * @param project Client ID in the system GSG.
     * @param secret Secret key.
     * @param version Version GSG.
     */
    public ClientGSG(final Integer project, final String secret, ApiVersion version) {
        this(project, secret, version.equals(ApiVersion.version_1) ? ClientGSG.defaultApiUrl : ClientGSG.defaultApiUrlV2);
    }

    /**
     * Constructor
     *
     * @param project Client ID in the system GSG.
     * @param secret Secret key.
     * @param apiURL URL to the GSG api.
     */
    public ClientGSG(final Integer project, final String secret, String apiURL) {
        this(project, secret, apiURL, ClientGSG.defaultThreadLimit);
    }

    /**
     * Constructor
     *
     * @param project Client ID in the system GSG.
     * @param secret Secret key.
     * @param apiURL URL to the GSG api.
     * @param threadLimit Thread limit.
     */
    public ClientGSG(final Integer project, final String secret, final String apiURL, final int threadLimit) {
        if (apiURL != null) {
            this.apiUrl = apiURL;
        } else {
            this.apiUrl = defaultApiUrl;
        }
        this.project = project;
        this.secret = secret;
        this.config = (new AsyncHttpClientConfig.Builder())
                .setAllowPoolingConnection(true)
                .setAllowSslConnectionPool(true)
                .addRequestFilter(new ThrottleRequestFilter(threadLimit))
                .setMaximumConnectionsPerHost(threadLimit)
                .setRequestTimeoutInMs(10000)
                .setIdleConnectionInPoolTimeoutInMs(10000)
                .build();
        this.client = new AsyncHttpClient(new NettyAsyncHttpProvider(config), config);
    }

    /**
     * Close all connections associated with this client. It is a good practice
     * to always close the client after use.
     */
    public void close() {
        this.client.close();
    }

    /**
     * Get status of the API (return json string).
     *
     * @return
     * @throws ExecutionException indicates an error in the HTTP backend
     * @throws InterruptedException indicates an interruption during the HTTP
     * operation
     * @throws IOException indicates an error from the API response
     */
    public String getStatus() throws ExecutionException, InterruptedException, IOException {
        return (new FutureAPIResponse(this.client.prepareGet(this.apiUrl).execute(this.getHandler()))).get().getMessage();
    }

    private AsyncHandler<APIResponse> getHandler() {
        return new AsyncHandler<APIResponse>() {
            private final Response.ResponseBuilder builder = new Response.ResponseBuilder();

            @Override
            public void onThrowable(Throwable t) {
            }

            @Override
            public AsyncHandler.STATE onBodyPartReceived(final HttpResponseBodyPart content) throws Exception {
                builder.accumulate(content);
                return AsyncHandler.STATE.CONTINUE;
            }

            @Override
            public AsyncHandler.STATE onStatusReceived(final HttpResponseStatus status) throws Exception {
                builder.accumulate(status);
                return AsyncHandler.STATE.CONTINUE;
            }

            @Override
            public AsyncHandler.STATE onHeadersReceived(final HttpResponseHeaders headers) throws Exception {
                builder.accumulate(headers);
                return AsyncHandler.STATE.CONTINUE;
            }

            @Override
            public APIResponse onCompleted() throws Exception {
                Response r = builder.build();
                return new APIResponse(r.getStatusCode(), r.getResponseBody());
            }
        };
    }

    /**
     * Get Action as a future.
     *
     * @param requestXML request XML string.
     * @return FutureAPIResponse
     * @throws IOException
     */
    private FutureAPIResponse getActionAsFuture(final String requestXML) throws IOException {
        final Request request = (new RequestBuilder("POST")).setUrl(this.apiUrl).setBody(requestXML).build();

        return new FutureAPIResponse(this.client.executeRequest(request, this.getHandler()));
    }

    /**
     * Get Action as a implementation BasicResponse
     *
     * @param clazz Class<? extends BasicResponse>
     * @param response FutureAPIResponse
     * @return <? extends BasicResponse>
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private BasicResponse getActionResponse(final Class<? extends BasicResponse> clazz, final FutureAPIResponse response) throws ExecutionException, InterruptedException, IOException, InstantiationException, IllegalAccessException {
        final int status = response.get().getStatus();
        final String message = new String(response.get().getMessage().getBytes("ISO-8859-1"), "UTF-8");

        if (status == ClientGSG.HTTP_OK) {
            return (BasicResponse) new JAXBFormater(clazz).stringToObject(message);
        } else {
            throw new IOException(message);
        }
    }

    //--------------------------------------------------------------------------
    // Executors
    /**
     * Sends a synchronous execute action "paysystems" request to the API.
     *
     * @return ActionPaySystemsResponse
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ActionPaySystemsResponse executePaySystemsAction() throws IOException, ExecutionException, InterruptedException, InstantiationException, IllegalAccessException {
        final ActionPaySystemsRequest actionPaySystemsRequest = new ActionPaySystemsRequest(project, secret);
        actionPaySystemsRequest.initSign();

        return (ActionPaySystemsResponse) getActionResponse(ActionPaySystemsResponse.class, getActionAsFuture(new JAXBFormater(ActionPaySystemsRequest.class).objectToString(actionPaySystemsRequest)));
    }

    /**
     * Sends a synchronous execute action "main_balance" request to the API.
     *
     * @return ActionMainBalanceResponse
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ActionMainBalanceResponse executeMainBalanceAction() throws IOException, ExecutionException, InterruptedException, InstantiationException, IllegalAccessException {
        final ActionMainBalanceRequest actionMainBalanceRequest = new ActionMainBalanceRequest(project, secret);
        actionMainBalanceRequest.initSign();

        return (ActionMainBalanceResponse) getActionResponse(ActionMainBalanceResponse.class, getActionAsFuture(new JAXBFormater(ActionMainBalanceRequest.class).objectToString(actionMainBalanceRequest)));
    }

    /**
     * Sends a synchronous execute action "check" request to the API.
     *
     * @param params CheckParams
     * @return ActionCheckResponse
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ActionCheckResponse executeCheckAction(final CheckParams params) throws IOException, ExecutionException, InterruptedException, InstantiationException, IllegalAccessException {
        final ActionCheckRequest actionCheckRequest = new ActionCheckRequest(project, secret);
        actionCheckRequest.setParams(params);
        actionCheckRequest.initSign(params.toStringForSign());

        return (ActionCheckResponse) getActionResponse(ActionCheckResponse.class, getActionAsFuture(new JAXBFormater(ActionCheckRequest.class).objectToString(actionCheckRequest)));
    }

    /**
     * Sends a synchronous execute action "pay" request to the API.
     *
     * @param params PayParams
     * @return ActionPayResponse
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ActionPayResponse executePayAction(final PayParams params) throws IOException, ExecutionException, InterruptedException, InstantiationException, IllegalAccessException {
        final ActionPayRequest actionPayRequest = new ActionPayRequest(project, secret);
        actionPayRequest.setParams(params);
        actionPayRequest.initSign(params.toStringForSign());

        return (ActionPayResponse) getActionResponse(ActionPayResponse.class, getActionAsFuture(new JAXBFormater(ActionPayRequest.class).objectToString(actionPayRequest)));
    }

    /**
     * Sends a synchronous execute action "pay_status" request to the API.
     *
     * @param params PayStatusParams
     * @return ActionPayStatusResponse
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ActionPayStatusResponse executePayStatusAction(final PayStatusParams params) throws IOException, ExecutionException, InterruptedException, InstantiationException, IllegalAccessException {
        final ActionPayStatusRequest actionPayStatusRequest = new ActionPayStatusRequest(project, secret);
        actionPayStatusRequest.setParams(params);
        actionPayStatusRequest.initSign(params.toStringForSign());

        return (ActionPayStatusResponse) getActionResponse(ActionPayStatusResponse.class, getActionAsFuture(new JAXBFormater(ActionPayStatusRequest.class).objectToString(actionPayStatusRequest)));
    }

    /**
     * Sends a synchronous execute action "errors" request to the API.
     *
     * @return ActionErrorsResponse
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ActionErrorsResponse executeErrorsAction() throws IOException, ExecutionException, InterruptedException, InstantiationException, IllegalAccessException {
        final ActionErrorsRequest actionErrorsRequest = new ActionErrorsRequest(project, secret);
        actionErrorsRequest.initSign();

        return (ActionErrorsResponse) getActionResponse(ActionErrorsResponse.class, getActionAsFuture(new JAXBFormater(ActionErrorsRequest.class).objectToString(actionErrorsRequest)));
    }

    /**
     * APIResponse as a future.
     */
    private class FutureAPIResponse implements Future {

        private final Future<APIResponse> apiResponse;

        public FutureAPIResponse(Future<APIResponse> apiResponse) {
            this.apiResponse = apiResponse;
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return this.apiResponse.cancel(mayInterruptIfRunning);
        }

        @Override
        public APIResponse get() throws ExecutionException, InterruptedException {
            return this.apiResponse.get();
        }

        @Override
        public APIResponse get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.apiResponse.get(timeout, unit);
        }

        @Override
        public boolean isCancelled() {
            return this.apiResponse.isCancelled();
        }

        @Override
        public boolean isDone() {
            return this.apiResponse.isDone();
        }

        public int getStatus() {
            try {
                return this.apiResponse.get().getStatus();
            } catch (InterruptedException | ExecutionException e) {
                return 0;
            }
        }

        public String getMessage() {
            try {
                return this.apiResponse.get().getMessage();
            } catch (InterruptedException | ExecutionException e) {
                return e.getMessage();
            }
        }
    }

    /**
     * API Response class for wrapping responses
     */
    private class APIResponse {

        private int status;
        private String message;

        public APIResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
