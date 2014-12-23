package com.dengionline.gsg.api.responses;

import javax.xml.bind.annotation.XmlElement;

/**
 * Базовые параметры ответа.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public class BasicResponse {

    /**
     * Статус запроса.
     */
    private Integer status;
    /**
     * Дата и время выполнения запроса.
     */
    private Integer timestamp;
    /**
     * Уникальный номер операции в системе.
     */
    private String reference;

    /**
     * Получить статус запроса.
     *
     * @return статус запроса.
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Установить статус запроса.
     *
     * @param status статус запроса.
     */
    @XmlElement(name = "status", required = true)
    protected void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Получить дату и время выполнения запроса.
     *
     * @return дата и время выполнения запроса.
     */
    public Integer getTimestamp() {
        return timestamp;
    }

    /**
     * Установить дату и время выполнения запроса.
     *
     * @param timestamp дата и время выполнения запроса.
     */
    @XmlElement(name = "timestamp", required = true)
    protected void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Получить уникальный номер операции в системе.
     *
     * @return уникальный номер операции в системе.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Установить уникальный номер операции в системе.
     *
     * @param reference уникальный номер операции в системе.
     */
    @XmlElement(name = "reference", required = true)
    protected void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\t<status>").append(status).append("</status>\n");
        builder.append("\t<reference>").append(timestamp).append("</reference>\n");
        builder.append("\t<timestamp>").append(reference).append("</timestamp>\n");

        return builder.toString();
    }
}
