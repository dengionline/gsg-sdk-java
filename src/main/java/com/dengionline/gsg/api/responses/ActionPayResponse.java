package com.dengionline.gsg.api.responses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Результат действия "Запрос на произведение выплаты". Action -> pay.
 *
 * Created by NetBeans IDE 02.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "response")
public class ActionPayResponse extends BasicResponse {

    /**
     * Номер инвойса.
     */
    private Integer invoice;
    /**
     * Использованный курс конвертации.
     */
    private BigDecimal rate;
    /**
     * Cумма входящего платежа в его валюте.
     */
    private BigDecimal income;
    /**
     * Cумма входящего платежа в валюте основного баланса.
     */
    private BigDecimal amount;
    /**
     * Cумма выплаты в систему-получатель.
     */
    private BigDecimal outcome;
    /**
     * Комиссия в валюте получателя.
     */
    private BigDecimal fee;

    /**
     * Получить номер инвойса.
     *
     * @return номер инвойса.
     */
    public Integer getInvoice() {
        return invoice;
    }

    @XmlElement(name = "invoice", required = true)
    private void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    /**
     * Получить использованный курс конвертации.
     *
     * @return использованный курс конвертации.
     */
    public BigDecimal getRate() {
        return rate;
    }

    @XmlElement(name = "rate", required = true)
    private void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * Получить сумму входящего платежа в его валюте.
     *
     * @return сумма входящего платежа в его валюте.
     */
    public BigDecimal getIncome() {
        return income;
    }

    @XmlElement(name = "income", required = true)
    private void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * Получить сумму входящего платежа в валюте основного баланса.
     *
     * @return сумма входящего платежа в валюте основного баланса.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    @XmlElement(name = "amount", required = true)
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Получить сумму входящего платежа в валюте основного баланса.
     *
     * @return сумма входящего платежа в валюте основного баланса.
     */
    public BigDecimal getOutcome() {
        return outcome;
    }

    @XmlElement(name = "outcome", required = true)
    private void setOutcome(BigDecimal outcome) {
        this.outcome = outcome;
    }

    /**
     * Получить комиссию в валюте получателя.
     *
     * @return комиссия в валюте получателя.
     */
    public BigDecimal getFee() {
        return fee;
    }

    @XmlElement(name = "fee", required = true)
    private void setFee(BigDecimal fee) {
        this.fee = fee;
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
        builder.append("\t<invoice>").append(invoice).append("</invoice>\n");
        builder.append("\t<rate>").append(rate).append("</rate>\n");
        builder.append("\t<income>").append(income).append("</income>\n");
        builder.append("\t<amount>").append(amount).append("</amount>\n");
        builder.append("\t<outcome>").append(outcome).append("</outcome>\n");
        builder.append("</response>");

        return builder.toString();
    }

}
