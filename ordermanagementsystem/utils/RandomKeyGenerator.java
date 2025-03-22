package org.example.ordermanagementsystem.utils;

import java.util.UUID;

public class RandomKeyGenerator {

    public static String generateRandomKey(String prefix) {

        String key = prefix + UUID.randomUUID().toString();
        return  key;

    }

}
