package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Запрос "Получение списка кодов уведомлений и их описаний".
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "request")
public class ActionErrorsRequest extends BasicRequest {

    /**
     * Конструктор.
     */
    public ActionErrorsRequest() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param project ID клиента в системе GSG.
     * @param secret Секретная фраза.
     */
    public ActionErrorsRequest(final Integer project, final String secret) {
        super.setProject(project);
        super.setSecret(secret);
        super.setTimestamp(System.currentTimeMillis() / 1000L);
        super.setAction(Action.errors);
    }
}
