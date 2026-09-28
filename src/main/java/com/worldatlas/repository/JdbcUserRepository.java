package com.worldatlas.repository;

import com.worldatlas.db.Database;
import com.worldatlas.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class JdbcUserRepository implements UserRepository {

    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT id, username, password_hash, email, phone, aadhaar_number, role FROM users WHERE username = '"
                + username + "'";
        try (Connection connection = Database.connect();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(sql)) {
            if (!rows.next()) {
                return Optional.empty();
            }
            return Optional.of(new User(rows.getLong("id"), rows.getString("username"), rows.getString("password_hash"),
                    rows.getString("email"), rows.getString("phone"), rows.getString("aadhaar_number"), rows.getString("role")));
        } catch (SQLException e) {
            throw new IllegalStateException("User lookup failed", e);
        }
    }
}
