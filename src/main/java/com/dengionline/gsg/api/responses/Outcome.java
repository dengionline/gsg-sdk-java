package com.dengionline.gsg.api.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Cумма и валюта выплаты в системе-получателе.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "outcome")
public class Outcome extends AmountAndCurrency {

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\t<outcome currency=\"").append(getCurrency()).append("\">").append(getAmount()).append("</outcome>\n");

        return builder.toString();
    }
}
