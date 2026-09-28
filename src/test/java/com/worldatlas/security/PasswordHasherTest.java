package com.worldatlas.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordHasherTest {

    private static final String TEST_PASSWORD = "Admin@Atlas2024";

    @Test
    void matchesTheSamePassword() {
        assertTrue(PasswordHasher.matches(TEST_PASSWORD, PasswordHasher.hash(TEST_PASSWORD)));
    }

    @Test
    void rejectsADifferentPassword() {
        assertFalse(PasswordHasher.matches("wrong", PasswordHasher.hash(TEST_PASSWORD)));
    }
}
