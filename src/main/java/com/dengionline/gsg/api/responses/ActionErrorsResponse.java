package com.dengionline.gsg.api.responses;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Результат действия "Получение списка кодов уведомлений и их описаний". Action
 * -> errors.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "response")
public class ActionErrorsResponse extends BasicResponse {

    /**
     * Список ошибок.
     */
    private List<Error> errors;

    /**
     * Получить список ошибок.
     *
     * @return список ошибок.
     */
    public List<Error> getErrors() {
        return errors;
    }

    @XmlElementWrapper(name = "errors")
    @XmlElement(name = "error", required = true)
    private void setErrors(List<Error> errors) {
        this.errors = errors;
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
        if (errors != null) {
            builder.append("\t<errors>\n");
            for (final Error error : errors) {
                builder.append(error.toString());
            }
            builder.append("\n\t<errors>\n");
        }
        builder.append("</response>");

        return builder.toString();
    }
}
