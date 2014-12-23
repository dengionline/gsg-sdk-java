package com.dengionline.gsg.api.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Результат действия "Предзапрос на произведение выплаты". Action -> check.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "response")
public class ActionCheckResponse extends BasicResponse {

    /**
     * Номер инвойса.
     */
    private Integer invoice;
    /**
     * Cумма запроса на выплату.
     */
    private Income income;
    /**
     * Cумма и валюта основного баланса проекта.
     */
    private Amount amount;
    /**
     * Cумма и валюта выплаты в системе-получателе.
     */
    private Outcome outcome;
    /**
     * Курсы конвертации.
     */
    private Rate rate;

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
     * Получить сумму запроса на выплату.
     *
     * @return сумма запроса на выплату.
     */
    public Income getIncome() {
        return income;
    }

    @XmlElement(name = "income", required = true)
    private void setIncome(Income income) {
        this.income = income;
    }

    /**
     * Получить сумму и валюта основного баланса проекта.
     *
     * @return сумма и валюта основного баланса проекта.
     */
    public Amount getAmount() {
        return amount;
    }

    @XmlElement(name = "amount", required = true)
    private void setAmount(Amount amount) {
        this.amount = amount;
    }

    /**
     * Получить сумму и валюта выплаты в системе-получателе.
     *
     * @return сумма и валюта выплаты в системе-получателе.
     */
    public Outcome getOutcome() {
        return outcome;
    }

    @XmlElement(name = "outcome", required = true)
    private void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    /**
     * Получить курсы конвертации.
     *
     * @return курсы конвертации.
     */
    public Rate getRate() {
        return rate;
    }

    @XmlElement(name = "rate", required = true)
    private void setRate(Rate rate) {
        this.rate = rate;
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
        builder.append(income.toString());
        builder.append(amount.toString());
        builder.append(outcome.toString());
        builder.append(rate.toString());
        builder.append("</response>");

        return builder.toString();
    }
}
