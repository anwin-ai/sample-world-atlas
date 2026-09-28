package com.worldatlas.model;

public class User {

    private final long id;
    private final String username;
    private final String passwordHash;
    private final String email;
    private final String phone;
    private final String aadhaarNumber;
    private final String role;

    public User(long id, String username, String passwordHash, String email, String phone, String aadhaarNumber, String role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.phone = phone;
        this.aadhaarNumber = aadhaarNumber;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public String getRole() {
        return role;
    }

    public boolean isAdmin() {
        return "ADMIN".equals(role);
    }
}
