package com.dengionline.gsg.api.responses;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Результат действия "Получение списка доступных систем". Action -> paysystems.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "response")
public class ActionPaySystemsResponse extends BasicResponse {

    /**
     * Список доступных систем.
     */
    private List<PaySystem> paySystems;

    /**
     * Получить список доступных систем.
     *
     * @return список доступных систем.
     */
    public List<PaySystem> getPaySystems() {
        return paySystems;
    }

    @XmlElementWrapper(name = "paysystems")
    @XmlElement(name = "paysystem", required = false)
    private void setPaySystems(List<PaySystem> paySystems) {
        this.paySystems = paySystems;
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
        if (paySystems != null) {
            builder.append("\t<paysystems>\n");
            for (final PaySystem paySystem : paySystems) {
                builder.append(paySystem.toString());
            }
            builder.append("\n\t<paysystems>\n");
        }
        builder.append("</response>");

        return builder.toString();
    }
}
