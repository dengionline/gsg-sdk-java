package com.dengionline.gsg.api.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Cумма и валюта основного баланса проекта.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "amount")
public class Amount extends AmountAndCurrency {

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\t<amount currency=\"").append(getCurrency()).append("\">").append(getAmount()).append("</amount>\n");

        return builder.toString();
    }
}
