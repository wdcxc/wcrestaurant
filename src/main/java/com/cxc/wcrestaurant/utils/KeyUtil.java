package com.cxc.wcrestaurant.utils;

import java.util.Random;

public class KeyUtil {
    public static synchronized String generateUniqueKey() {
        Random random = new Random();
        Integer ranInt = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(ranInt);
    }
}
