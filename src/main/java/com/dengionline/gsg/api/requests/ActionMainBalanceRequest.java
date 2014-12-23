package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Запрос "Получение суммы баланса".
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "request")
public class ActionMainBalanceRequest extends BasicRequest {

    /**
     * Конструктор.
     */
    public ActionMainBalanceRequest() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param project ID клиента в системе GSG.
     * @param secret Секретная фраза.
     */
    public ActionMainBalanceRequest(final Integer project, final String secret) {
        super.setProject(project);
        super.setSecret(secret);
        super.setTimestamp(System.currentTimeMillis() / 1000L);
        super.setAction(Action.main_balance);
    }
}
