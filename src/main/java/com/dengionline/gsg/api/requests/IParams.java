package com.dengionline.gsg.api.requests;

/**
 * Приведение параметров к строке для формирования подписи.
 *
 * Created by NetBeans IDE 01.04.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public interface IParams {

    /**
     * Формирование строки параметров для подписи.
     *
     * @return строка параметров для подписи.
     */
    public String toStringForSign();
}
