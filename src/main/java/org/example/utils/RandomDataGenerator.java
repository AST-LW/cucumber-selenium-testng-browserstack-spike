package org.example.utils;

import java.util.Random;

public class RandomDataGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase();
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUM = UPPER + LOWER + DIGITS;
    private static final Random RANDOM = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHA_NUM.charAt(RANDOM.nextInt(ALPHA_NUM.length())));
        }
        return sb.toString();
    }

    public static int generateRandomNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static String generateRandomEmail(int length) {
        return generateRandomString(length) + "@example.com";
    }
}
