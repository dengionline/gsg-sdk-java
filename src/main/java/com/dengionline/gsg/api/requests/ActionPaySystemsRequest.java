package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Запрос "Получение списка доступных систем – получателей платежа и их
 * параметров".
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "request")
public class ActionPaySystemsRequest extends BasicRequest {

    /**
     * Конструктор.
     */
    public ActionPaySystemsRequest() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param project ID клиента в системе GSG.
     * @param secret Секретная фраза.
     */
    public ActionPaySystemsRequest(final Integer project, final String secret) {
        super.setProject(project);
        super.setSecret(secret);
        super.setTimestamp(System.currentTimeMillis() / 1000L);
        super.setAction(Action.paysystems);
    }
}
