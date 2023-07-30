package com.example.simpleboard.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

    private Long id;

    private String name;

    private String password;

    @Builder
    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
