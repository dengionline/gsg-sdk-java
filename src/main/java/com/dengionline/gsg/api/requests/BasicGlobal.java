package com.dengionline.gsg.api.requests;

/**
 * Basic class for requests.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public class BasicGlobal {

    /**
     * Секретная фраза.
     */
    private String secret;

    /**
     * Конструктор.
     */
    public BasicGlobal() {
    }

    /**
     * Получить секретную фразу.
     *
     * @return
     */
    protected String getSecret() {
        return secret;
    }

    /**
     * Установить секретную фразу.
     *
     * @param secret секретная фраза.
     */
    protected void setSecret(String secret) {
        this.secret = secret;
    }

}
