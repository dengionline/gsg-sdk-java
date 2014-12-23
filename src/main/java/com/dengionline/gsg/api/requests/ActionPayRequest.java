package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Запрос "Запрос на произведение выплаты".
 *
 * Created by NetBeans IDE 02.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "request")
public class ActionPayRequest extends BasicRequest {

    /**
     * Дополнительные параметры.
     */
    private PayParams params;

    /**
     * Конструктор.
     */
    public ActionPayRequest() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param project ID клиента в системе GSG.
     * @param secret Секретная фраза.
     */
    public ActionPayRequest(final Integer project, final String secret) {
        super.setProject(project);
        super.setSecret(secret);
        super.setTimestamp(System.currentTimeMillis() / 1000L);
        super.setAction(Action.pay);
    }

    /**
     * Получить доп. параметры.
     *
     * @return PayParams
     */
    public PayParams getParams() {
        return params;
    }

    /**
     * Установить доп. параметры.
     *
     * @param params PayParams
     */
    @XmlElement(name = "params", required = true)
    public void setParams(PayParams params) {
        this.params = params;
    }
}
