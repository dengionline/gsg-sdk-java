package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Дополнительные параметры для запроса "Запрос на произведение выплаты".
 *
 * Created by NetBeans IDE 02.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "params")
public class PayParams implements IParams {

    /**
     * ID транзакции, полученный в действии check.
     */
    private Integer invoice;
    /**
     * ID транзакции во внешней системе (системе проекта).
     */
    private String txnId;
    /**
     * Сумма выплаты.
     */
    private Double amount;
    /**
     * ID валюты платежа.
     */
    private String currency;

    /**
     * Конструктор.
     */
    public PayParams() {
        this.txnId = "";
        this.currency = "";
    }

    /**
     * Конструктор с параметрами.
     *
     * @param invoice ID транзакции, полученный в действии check.
     * @param txnId ID транзакции во внешней системе (системе проекта).
     * @param amount Сумма выплаты.
     * @param currency ID валюты платежа.
     */
    public PayParams(Integer invoice, String txnId, Double amount, String currency) {
        this.invoice = invoice;
        this.txnId = txnId;
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Получить ID транзакции, полученный в действии check.
     *
     * @return ID транзакции, полученный в действии check.
     */
    public Integer getInvoice() {
        return invoice;
    }

    /**
     * Установить ID транзакции, полученный в действии check.
     *
     * @param invoice ID транзакции, полученный в действии check.
     */
    @XmlElement(name = "invoice", required = true)
    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    /**
     * Получить ID транзакции во внешней системе (системе проекта).
     *
     * @return ID транзакции во внешней системе (системе проекта).
     */
    public String getTxnId() {
        return txnId;
    }

    /**
     * Установить ID транзакции во внешней системе (системе проекта).
     *
     * @param txnId ID транзакции во внешней системе (системе проекта).
     */
    @XmlElement(name = "txn_id", required = true)
    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    /**
     * Получить сумму выплаты.
     *
     * @return сумма выплаты.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Установить сумму выплаты.
     *
     * @param amount сумма выплаты.
     */
    @XmlElement(name = "amount", required = false)
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Получить ID валюты платежа.
     *
     * @return ID валюты платежа.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Установить ID валюты платежа.
     *
     * @param currency ID валюты платежа.
     */
    @XmlElement(name = "currency", required = false)
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Формирование строки параметров для подписи.
     *
     * @return строка параметров для подписи.
     */
    @Override
    public String toStringForSign() {
        return new StringBuilder().append(amount).append(currency).append(invoice).append(txnId).toString();
    }

}
