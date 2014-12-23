package com.dengionline.gsg.api.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Алгоритм шифрования md5.
 *
 * Created by NetBeans IDE 31.03.2014.
 *
 * @author Yuriy Dolgushin <y.dolgushin@dengionline.com>
 * @version 1.0
 * @since 1.0
 */
public class MD5 {

    /**
     * Получить хэш.
     *
     * @param str входная строка.
     * @return хэшированную строку.
     */
    static public String getHash(String str) {
        final StringBuilder hexString = new StringBuilder();

        try {
            final MessageDigest md5 = MessageDigest.getInstance("md5");

            md5.reset();
            md5.update(str.getBytes());

            byte messageDigest[] = md5.digest();

            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);

                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }
        } catch (final NoSuchAlgorithmException e) {
            return e.toString();
        }

        return hexString.toString();
    }
}
