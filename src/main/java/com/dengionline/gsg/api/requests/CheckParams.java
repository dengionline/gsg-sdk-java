package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Дополнительные параметры для запроса "Предзапрос на произведение выплаты".
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "params")
public class CheckParams implements IParams {

    /**
     * ID транзакции во внешней системе (системе проекта).
     */
    private String txnId;
    /**
     * ID системы-получателя выплат в системе GSG.
     */
    private Integer paySystem;
    /**
     * ID аккаунта в системе получателя платежа, например, номер карты.
     */
    private String account;
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
    public CheckParams() {
        this.account = "";
        this.txnId = "";
        this.currency = "";
    }

    /**
     * Конструктор с параметрамии.
     *
     * @param txnId ID транзакции во внешней системе (системе проекта).
     * @param paySystem ID системы-получателя выплат в системе GSG.
     * @param account ID аккаунта в системе получателя платежа, например, номер
     * карты.
     * @param amount Сумма выплаты.
     * @param currency ID валюты платежа.
     */
    public CheckParams(String txnId, Integer paySystem, String account, Double amount, String currency) {
        this.txnId = txnId;
        this.paySystem = paySystem;
        this.account = account;
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Получить ID транзакции во внешней системе (системе проекта).
     *
     * @return ID транзакции во внешней системе (системе проекта)
     */
    public String getTxnId() {
        return txnId;
    }

    /**
     * Установить ID транзакции во внешней системе (системе проекта)
     *
     * @param txnId ID транзакции во внешней системе (системе проекта)
     */
    @XmlElement(name = "txn_id", required = true)
    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    /**
     * Получить ID системы-получателя выплат в системе GSG.
     *
     * @return ID системы-получателя выплат в системе GSG.
     */
    public Integer getPaySystem() {
        return paySystem;
    }

    /**
     * Установить ID системы-получателя выплат в системе GSG.
     *
     * @param paySystem ID системы-получателя выплат в системе GSG.
     */
    @XmlElement(name = "paysystem", required = true)
    public void setPaySystem(Integer paySystem) {
        this.paySystem = paySystem;
    }

    /**
     * Получить ID аккаунта в системе получателя платежа, например, номер карты.
     *
     * @return ID аккаунта в системе получателя платежа, например, номер карты.
     */
    public String getAccount() {
        return account;
    }

    /**
     * Установить ID аккаунта в системе получателя платежа, например, номер
     * карты.
     *
     * @param account ID аккаунта в системе получателя платежа, например, номер
     * карты.
     */
    @XmlElement(name = "account", required = true)
    public void setAccount(String account) {
        this.account = account;
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
    @XmlElement(name = "amount", required = true)
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
    @XmlElement(name = "currency", required = true)
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
        return new StringBuilder().append(account).append(amount).append(currency).append(paySystem).append(txnId).toString();
    }
}
