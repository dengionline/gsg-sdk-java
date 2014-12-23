package com.dengionline.gsg.api.responses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Результат действия "Получение суммы баланса". Action -> main_balance.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "response")
public class ActionMainBalanceResponse extends BasicResponse {

    /**
     * Баланс проекта в его базовой валюте.
     */
    private BigDecimal balance;
    /**
     * Валюта баланса.
     */
    private String currency;

    /**
     * Получить баланс проекта в его базовой валюте.
     *
     * @return баланс проекта в его базовой валюте.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    @XmlElement(name = "balance", required = true)
    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Получить валюту баланса.
     *
     * @return валюта баланса.
     */
    public String getCurrency() {
        return currency;
    }

    @XmlElement(name = "currency", required = true)
    private void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        builder.append("<response>\n");
        builder.append(super.toString());
        builder.append("\t<balance>").append(balance).append("</balance>\n");
        builder.append("\t<currency>").append(currency).append("</currency>\n");
        builder.append("</response>");

        return builder.toString();
    }

}
