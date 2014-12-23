package com.dengionline.gsg.api.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Описание ошибки.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "error")
public class Error {

    /*
     * Номер уведомления.
     */
    private Integer id;
    /**
     * Текст уведомления.
     */
    private String descr;

    /**
     * Получить номер уведомления.
     *
     * @return номер уведомления.
     */
    public Integer getId() {
        return id;
    }

    @XmlElement(name = "id", required = true)
    private void setId(Integer id) {
        this.id = id;
    }

    /**
     * Получить текст уведомления.
     *
     * @return текст уведомления.
     */
    public String getDescr() {
        return descr;
    }

    @XmlElement(name = "descr", required = true)
    private void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\t\t<error>\n");
        builder.append("\t\t\t<id>").append(id).append("</id>\n");
        builder.append("\t\t\t<descr>").append(descr).append("</descr>\n");
        builder.append("\t\t</error>\n");

        return builder.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
