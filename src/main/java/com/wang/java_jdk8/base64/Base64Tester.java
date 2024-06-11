package com.wang.java_jdk8.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

/**
 * Base64Tester
 *
 * @author wangfj
 * @date 2024/6/11
 */
public class Base64Tester {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID()).append("@");
        }

        byte[] mimeBytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
        String mimeEncodedString = Base64.getMimeEncoder(32, "@~@\n\n".getBytes(StandardCharsets.UTF_8)).encodeToString(mimeBytes);
        System.out.println(mimeEncodedString);
        System.out.println();

        byte[] base64decodedBytes = Base64.getMimeDecoder().decode("OTkwNWYxY2QtMDBkYS00Y2M1LTgwMGUt");

        System.out.println(new String(base64decodedBytes, StandardCharsets.UTF_8));
        System.out.println(UUID.randomUUID());

    }
}
