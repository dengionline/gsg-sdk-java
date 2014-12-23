package com.dengionline.gsg.api.responses;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Платёжная система.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "paysystem")
public class PaySystem {

    /**
     * Идентификатор системы-получателя.
     */
    private Integer id;
    /**
     * Мнемонический идентификатор системы-получателя alias.
     */
    private String tag;
    /**
     * Наименование системы-получателя.
     */
    private String title;
    /**
     * Наименование юридического лица.
     */
    private String jName;
    /**
     * Идентификатор регионального баланса, к которому относится система.
     */
    private String region;
    /**
     * Сумма минимальной единичной выплаты.
     */
    private BigDecimal minAmount;
    /**
     * Сумма максимальной единичной выплаты.
     */
    private BigDecimal maxAmount;
    /**
     * Подсказка, что мерчант хочет получить.
     */
    private String accountName;
    /**
     * Регулярное выражение для проверки аккаунта – по нему он проверяет то, что
     * хочет получить. Например, номер телефона.
     */
    private String accountRegexp;
    /**
     * Валюта платежной системы.
     */
    private String currencyId;

    /**
     * Получить идентификатор системы-получателя.
     *
     * @return идентификатор системы-получателя.
     */
    public Integer getId() {
        return id;
    }

    @XmlElement(name = "id", required = true)
    private void setId(Integer id) {
        this.id = id;
    }

    /**
     * Получить мнемонический идентификатор системы-получателя alias.
     *
     * @return мнемонический идентификатор системы-получателя alias.
     */
    public String getTag() {
        return tag;
    }

    @XmlElement(name = "tag", required = false)
    private void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Получить наименование системы-получателя.
     *
     * @return наименование системы-получателя.
     */
    public String getTitle() {
        return title;
    }

    @XmlElement(name = "title", required = true)
    private void setTitle(String title) {
        this.title = title;
    }

    /**
     * Получить наименование юридического лица.
     *
     * @return наименование юридического лица.
     */
    public String getjName() {
        return jName;
    }

    @XmlElement(name = "jname", required = false)
    private void setjName(String jName) {
        this.jName = jName;
    }

    /**
     * Получить идентификатор регионального баланса, к которому относится
     * система.
     *
     * @return идентификатор регионального баланса, к которому относится
     * система.
     */
    public String getRegion() {
        return region;
    }

    @XmlElement(name = "region", required = true)
    private void setRegion(String region) {
        this.region = region;
    }

    /**
     * Получить сумму минимальной единичной выплаты.
     *
     * @return сумма минимальной единичной выплаты.
     */
    public BigDecimal getMinAmount() {
        return minAmount;
    }

    @XmlElement(name = "min_amount", required = true)
    private void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * Получить сумму максимальной единичной выплаты.
     *
     * @return сумма максимальной единичной выплаты.
     */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    @XmlElement(name = "max_amount", required = true)
    private void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * Получить подсказку, что мерчант хочет получить.
     *
     * @return подсказка, что мерчант хочет получить.
     */
    public String getAccountName() {
        return accountName;
    }

    @XmlElement(name = "account_name", required = false)
    private void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Получить регулярное выражение для проверки аккаунта – по нему он
     * проверяет то, что хочет получить. Например, номер телефона.
     *
     * @return регулярное выражение для проверки аккаунта – по нему он проверяет
     * то, что хочет получить. Например, номер телефона.
     */
    public String getAccountRegexp() {
        return accountRegexp;
    }

    @XmlElement(name = "account_regexp", required = true)
    private void setAccountRegexp(String accountRegexp) {
        this.accountRegexp = accountRegexp;
    }

    /**
     * Получить валюту платежной системы.
     *
     * @return валюта платежной системы.
     */
    public String getCurrencyId() {
        return currencyId;
    }

    @XmlElement(name = "currency_id", required = true)
    private void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * Показать как XML.
     *
     * @return строка в формате XML.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        builder.append("\t\t<paysystem>\n");
        builder.append("\t\t\t<id>").append(id).append("</id>\n");
        builder.append("\t\t\t<tag>").append(tag).append("</tag>\n");
        builder.append("\t\t\t<title>").append(title).append("</title>\n");
        builder.append("\t\t\t<jname>").append(jName).append("</jname>\n");
        builder.append("\t\t\t<region>").append(region).append("</region>\n");
        builder.append("\t\t\t<min_amount>").append(minAmount).append("</min_amount>\n");
        builder.append("\t\t\t<max_amount>").append(maxAmount).append("</max_amount>\n");
        builder.append("\t\t\t<account_name>").append(accountName).append("</account_name>\n");
        builder.append("\t\t\t<account_regexp>").append(accountRegexp).append("</account_regexp>\n");
        builder.append("\t\t\t<currency_id>").append(currencyId).append("</currency_id>\n");
        builder.append("\t\t</paysystem>");

        return builder.toString();
    }
}
