package com.dengionline.gsg.api.utils;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * JAXB форматирование.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @param <T>
 * @since 1.0
 */
public class JAXBFormater<T> {

    private final Class<T> clazz;

    /**
     * Конструктор.
     *
     * @param clazz Class<T>
     */
    public JAXBFormater(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Формирование XML строки из объекта.
     *
     * @param object T
     * @return XML строка.
     */
    public String objectToString(final T object) {
        try {
            final StringWriter writer = new StringWriter();
            final JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, writer);

            return writer.toString();
        } catch (JAXBException ignore) {
        }

        return "";
    }

    /**
     * Формирование объекта из строки XML.
     *
     * @param xmlData строка XML
     * @return T.
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public T stringToObject(final String xmlData) throws InstantiationException, IllegalAccessException {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (T) jaxbUnmarshaller.unmarshal(new StringReader(xmlData));
        } catch (JAXBException ignore) {
        }

        return clazz.newInstance();
    }
}
