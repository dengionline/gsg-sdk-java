package com.dengionline.gsg.api.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Сумма и валюта запроса на выплату.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "income")
public class Income extends AmountAndCurrency {

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\t<income currency=\"").append(getCurrency()).append("\">").append(getAmount()).append("</income>\n");

        return builder.toString();
    }
}
