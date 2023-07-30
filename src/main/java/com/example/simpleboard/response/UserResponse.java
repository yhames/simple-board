package com.example.simpleboard.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

    private long id;

    private String name;

    @Builder
    public UserResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
