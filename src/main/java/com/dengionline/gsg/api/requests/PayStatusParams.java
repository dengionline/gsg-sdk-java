package com.dengionline.gsg.api.requests;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Дополнительные параметры для запроса "Получение статуса транзакции по ее
 * идентификатору".
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "params")
public class PayStatusParams implements IParams {

    /**
     * ID транзакции, полученный в действии check.
     */
    private Integer invoice;
    /**
     * ID транзакции во внешней системе (системе проекта).
     */
    private String txnId;

    /**
     * Конструктор.
     */
    public PayStatusParams() {
        this.txnId = "";
    }

    /**
     * Конструктор с параметрами.
     *
     * @param invoice ID транзакции, полученный в действии check.
     * @param txnId ID транзакции во внешней системе (системе проекта).
     */
    public PayStatusParams(Integer invoice, String txnId) {
        this.invoice = invoice;
        this.txnId = txnId;
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
     * Формирование строки параметров для подписи.
     *
     * @return строка параметров для подписи.
     */
    @Override
    public String toStringForSign() {
        return new StringBuilder().append(invoice).append(txnId).toString();
    }
}
