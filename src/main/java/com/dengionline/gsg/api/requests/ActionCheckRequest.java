package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Запрос "Предзапрос на произведение выплаты".
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "request")
public class ActionCheckRequest extends BasicRequest {

    /**
     * Дополнительные параметры.
     */
    private CheckParams params;

    /**
     * Конструктор.
     */
    public ActionCheckRequest() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param project ID клиента в системе GSG.
     * @param secret Секретная фраза.
     */
    public ActionCheckRequest(final Integer project, final String secret) {
        super.setProject(project);
        super.setSecret(secret);
        super.setTimestamp(System.currentTimeMillis() / 1000L);
        super.setAction(Action.check);
    }

    /**
     * Получить доп. параметры.
     *
     * @return CheckParams
     */
    public CheckParams getParams() {
        return params;
    }

    /**
     * Установить доп. параметры.
     *
     * @param params CheckParams
     */
    @XmlElement(name = "params", required = true)
    public void setParams(CheckParams params) {
        this.params = params;
    }
}
