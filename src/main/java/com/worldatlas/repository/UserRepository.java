package com.worldatlas.repository;

import com.worldatlas.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
}
