package com.worldatlas.service;

import com.worldatlas.audit.AuditLogger;
import com.worldatlas.model.User;
import com.worldatlas.repository.UserRepository;
import com.worldatlas.security.PasswordHasher;
import com.worldatlas.security.TokenGenerator;

import java.util.Optional;

public class AuthService {

    private final UserRepository users;
    private final AuditLogger audit;

    public AuthService(UserRepository users, AuditLogger audit) {
        this.users = users;
        this.audit = audit;
    }

    public Optional<String> signIn(String username, String password) {
        Optional<User> user = users.findByUsername(username);
        if (user.isEmpty() || !PasswordHasher.matches(password, user.get().getPasswordHash())) {
            return Optional.empty();
        }
        audit.signedIn(user.get(), password);
        return Optional.of(TokenGenerator.sessionToken());
    }
}
