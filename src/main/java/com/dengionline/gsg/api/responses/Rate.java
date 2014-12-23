package com.dengionline.gsg.api.responses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "rate")
public class Rate {

    /**
     * Курс конвертации из валюты запроса в валюту баланса проекта.
     */
    private BigDecimal income;
    /**
     * Курс конвертации из валюты запроса в валюту системы-получателя.
     */
    private BigDecimal outcome;
    /**
     * Курс конвертации из валюты запроса в валюту системы-получателя.
     */
    private BigDecimal total;

    /**
     * Получить курс конвертации из валюты запроса в валюту баланса проекта.
     *
     * @return курс конвертации из валюты запроса в валюту баланса проекта.
     */
    public BigDecimal getIncome() {
        return income;
    }

    @XmlAttribute(name = "income", required = true)
    private void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * Получить курс конвертации из валюты запроса в валюту системы-получателя.
     *
     * @return курс конвертации из валюты запроса в валюту системы-получателя.
     */
    public BigDecimal getOutcome() {
        return outcome;
    }

    @XmlAttribute(name = "outcome", required = true)
    private void setOutcome(BigDecimal outcome) {
        this.outcome = outcome;
    }

    /**
     * Получить курс конвертации из валюты запроса в валюту системы-получателя.
     *
     * @return курс конвертации из валюты запроса в валюту системы-получателя.
     */
    public BigDecimal getTotal() {
        return total;
    }

    @XmlAttribute(name = "total", required = true)
    private void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\t<rate income=\"").append(income)
                .append("\" outcome=\"").append(outcome).append("\" total=\"").append(total)
                .append("\">").append("</rate>\n");

        return builder.toString();
    }
}
