package com.dengionline.gsg.api.requests;

import com.dengionline.gsg.api.utils.MD5;
import javax.xml.bind.annotation.XmlElement;

/**
 * Basic parameters of the request.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public class BasicRequest extends BasicGlobal {

    /**
     * ID клиента в системе GSG.
     */
    private Integer project;
    /**
     * Дата и время выполнения запроса.
     */
    private Long timestamp;
    /**
     * Идентификатор желаемого действия.
     */
    private String action;
    /**
     * Цифровая подпись запроса.
     */
    private String sign;

    /**
     * Конструктор.
     */
    public BasicRequest() {
    }

    /**
     * Получить ID клиента в системе GSG.
     *
     * @return ID клиента в системе GSG
     */
    protected Integer getProject() {
        return project;
    }

    /**
     * Установить ID клиента в системе GSG.
     *
     * @param project ID клиента в системе GSG
     */
    @XmlElement(name = "project", required = true)
    protected void setProject(Integer project) {
        this.project = project;
    }

    /**
     * Получить дату и время выполнения запроса.
     *
     * @return дата и время выполнения запроса
     */
    protected Long getTimestamp() {
        return timestamp;
    }

    /**
     * Установить дату и время выполнения запроса..
     *
     * @param timestamp дата и время выполнения запроса
     */
    @XmlElement(name = "timestamp", required = true)
    protected void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Получить идентификатор желаемого действия.
     *
     * @return идентификатор желаемого действия
     */
    protected String getAction() {
        return action;
    }

    /**
     * Установить идентификатор желаемого действия как перечисление Action.
     *
     * @param action идентификатор желаемого действия как перечисление Action
     */
    protected void setAction(Action action) {
        this.setAction(action.name());
    }

    /**
     * Установить идентификатор желаемого действия
     *
     * @param action идентификатор желаемого действия
     */
    @XmlElement(name = "action", required = true)
    protected void setAction(String action) {
        this.action = action;
    }

    /**
     * Получить цифровую подпись запроса.
     *
     * @return цифровая подпись запроса
     */
    protected String getSign() {
        return sign;
    }

    /**
     * Установить цифровую подпись запроса.
     *
     * @param sign цифровая подпись запроса
     */
    @XmlElement(name = "sign", required = true)
    protected void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Инициализировать цифровую подпись запроса без доп. параметров.
     */
    public void initSign() {
        initSign("");
    }

    /**
     * Инициализировать цифровую подпись запроса с доп. параметрами.
     *
     * @param params доп. параметры
     */
    public void initSign(final String params) {
        this.sign = MD5.getHash(new StringBuilder().append(this.getTimestamp()).append(this.getProject()).append(this.getAction()).append(params).append(getSecret()).toString());
    }

    /**
     * Возможные действия.
     */
    protected static enum Action {

        /**
         * Получение списка доступных систем – получателей платежа и их
         * параметров.
         */
        paysystems,
        /**
         * Получение суммы основного баланса.
         */
        main_balance,
        /**
         * Предзапрос на проведение выплаты.
         */
        check,
        /**
         * Запрос на проведение выплаты.
         */
        pay,
        /**
         * Получение статуса транзакции по ее идентификатору.
         */
        pay_status,
        /**
         * Получение списка кодов уведомлений и их описаний.
         */
        errors
    }
}
