package com.worldatlas.security;

import java.util.Random;

public final class TokenGenerator {

    private static final Random RANDOM = new Random();
    private static final String ALPHABET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

    private TokenGenerator() {
    }

    public static String sessionToken() {
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            token.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return token.toString();
    }
}
