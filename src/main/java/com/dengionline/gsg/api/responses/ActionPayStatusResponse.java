package com.dengionline.gsg.api.responses;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Результат действия "Получение статуса транзакции по ее идентификатору".
 * Action -> pay_status.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "response")
public class ActionPayStatusResponse extends BasicResponse {

    /**
     * Статус транзакции.
     */
    private String payStatus;
    /**
     * Cумма входящего платежа в его валюте.
     */
    private BigDecimal income;
    /**
     * Использованный курс конвертации.
     */
    private BigDecimal rate;
    /**
     * Сумма входящего платежа в валюте основного баланса.
     */
    private BigDecimal amount;
    /**
     * Сумма выплаты в систему-получатель.
     */
    private BigDecimal outcome;
    /**
     * % комиссии по данному провайдеру.
     */
    private BigDecimal fee;
    /**
     * Дата создания инвойса.
     */
    private String tsCreate;
    /**
     * Дата произведения выплаты.
     */
    private String tsClose;

    /**
     * Получить статус транзакции.
     *
     * @return статус транзакции.
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * Получить статус транзакции как enum.
     *
     * @return статус транзакции как enum.
     */
    public PayStatus getPayStatusAsEnum() {
        if ("new".equals(payStatus)) {
            return PayStatus._new;
        }

        return PayStatus.valueOf(payStatus);
    }

    @XmlElement(name = "pay_status", required = true)
    private void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * Получить сумму входящего платежа в его валюте.
     *
     * @return сумма входящего платежа в его валюте.
     */
    public BigDecimal getIncome() {
        return income;
    }

    @XmlElement(name = "income", required = false)
    private void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * Получить использованный курс конвертации.
     *
     * @return использованный курс конвертации.
     */
    public BigDecimal getRate() {
        return rate;
    }

    @XmlElement(name = "rate", required = false)
    private void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * Получить сумму входящего платежа в валюте основного баланса.
     *
     * @return сумма входящего платежа в валюте основного баланса.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    @XmlElement(name = "amount", required = false)
    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Получить сумму выплаты в систему-получатель.
     *
     * @return сумма выплаты в систему-получатель.
     */
    public BigDecimal getOutcome() {
        return outcome;
    }

    @XmlElement(name = "outcome", required = false)
    private void setOutcome(BigDecimal outcome) {
        this.outcome = outcome;
    }

    /**
     * Получить % комиссии по данному провайдеру.
     *
     * @return % комиссии по данному провайдеру.
     */
    public BigDecimal getFee() {
        return fee;
    }

    @XmlElement(name = "fee", required = false)
    private void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * Получить дату создания инвойса.
     *
     * @return дата создания инвойса.
     */
    public String getTsCreate() {
        return tsCreate;
    }

    /**
     * Получить дату создания инвойса как java.util.Date.
     *
     * @return датa создания инвойса как java.util.Date.
     * @throws ParseException
     */
    public Date getTsCreateAsDate() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tsCreate);
    }

    @XmlElement(name = "ts_create", required = false)
    private void setTsCreate(String tsCreate) {
        this.tsCreate = tsCreate;
    }

    /**
     * Получить дату произведения выплаты.
     *
     * @return дата произведения выплаты.
     */
    public String getTsClose() {
        return tsClose;
    }

    /**
     * Получить дату произведения выплаты как java.util.Date.
     *
     * @return дата произведения выплаты как java.util.Date.
     * @throws ParseException
     */
    public Date getTsCloseAsDate() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tsClose);
    }

    @XmlElement(name = "ts_close", required = false)
    private void setTsClose(String tsClose) {
        this.tsClose = tsClose;
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
        builder.append("\t<pay_status>").append(payStatus).append("</pay_status>\n");
        builder.append("\t<income>").append(income).append("</income>\n");
        builder.append("\t<rate>").append(rate).append("</rate>\n");
        builder.append("\t<amount>").append(amount).append("</amount>\n");
        builder.append("\t<outcome>").append(outcome).append("</outcome>\n");
        builder.append("\t<fee>").append(fee).append("</fee>\n");
        builder.append("\t<ts_create>").append(tsCreate).append("</ts_create>\n");
        builder.append("\t<ts_close>").append(tsClose).append("</ts_close>\n");
        builder.append("</response>");

        return builder.toString();
    }

    /**
     * Статус транзакции.
     */
    public static enum PayStatus {

        /**
         * Новая, не проведена.
         */
        _new,
        /**
         * Обрабатывается сейчас.
         */
        processing,
        /**
         * В очереди, ожидает обработки.
         */
        pending,
        /**
         * Выплата проведена.
         */
        paid,
        /**
         * Ошибка выплаты.
         */
        error,
        /**
         * Выплата отменена, средства возвращены на баланс проекта.
         */
        cancelled
    }
}
