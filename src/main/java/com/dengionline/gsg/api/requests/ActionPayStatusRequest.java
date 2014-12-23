package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Запрос "Получение статуса транзакции по ее идентификатору".
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "request")
public class ActionPayStatusRequest extends BasicRequest {

    /**
     * Дополнительные параметры.
     */
    private PayStatusParams params;

    /**
     * Конструктор.
     */
    public ActionPayStatusRequest() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param project ID клиента в системе GSG.
     * @param secret Секретная фраза.
     */
    public ActionPayStatusRequest(final Integer project, final String secret) {
        super.setProject(project);
        super.setSecret(secret);
        super.setTimestamp(System.currentTimeMillis() / 1000L);
        super.setAction(Action.pay_status);
    }

    /**
     * Получить доп. параметры.
     *
     * @return PayStatusParams
     */
    public PayStatusParams getParams() {
        return params;
    }

    /**
     * Установить доп. параметры.
     *
     * @param params PayStatusParams
     */
    @XmlElement(name = "params", required = true)
    public void setParams(PayStatusParams params) {
        this.params = params;
    }

}
