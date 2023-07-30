package com.example.simpleboard.repository;

import com.example.simpleboard.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByName(String name);

    Optional<User> findById(long id);
}
