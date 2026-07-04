package com.urlshortener.urlshortener.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

public class ShortCodeGenerator {

    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomShortCode(){

        StringBuilder shortCode = new StringBuilder();
        final Random rand = new Random();
        final int length = BASE62.length();

        for (int idx = 0;idx < 6;idx++){
            shortCode.append(BASE62.charAt(rand.nextInt(length)));
        }

        return shortCode.toString();
    };


}
