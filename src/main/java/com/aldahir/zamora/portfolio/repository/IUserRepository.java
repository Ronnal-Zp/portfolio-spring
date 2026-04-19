package com.aldahir.zamora.portfolio.repository;

import com.aldahir.zamora.portfolio.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByUsername(String username);
}
