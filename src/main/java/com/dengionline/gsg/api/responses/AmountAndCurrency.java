package com.dengionline.gsg.api.responses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Общий класс для суммы и валюты.
 *
 * Created by NetBeans IDE 02.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public class AmountAndCurrency {

    /**
     * Сумма.
     */
    private BigDecimal amount;
    /**
     * Валюта.
     */
    private String currency;

    /**
     * Получить сумму.
     *
     * @return сумма.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    @XmlValue
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Получить валюту.
     *
     * @return валюта.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Получить валюту как Integer.
     *
     * @return валюта как Integer.
     */
    public Integer getCurrencyAsInteger() {
        return Integer.parseInt(currency);
    }

    @XmlAttribute(name = "currency", required = true)
    private void setCurrency(String currency) {
        this.currency = currency;
    }
}
