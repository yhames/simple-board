package com.example.simpleboard.domain;

import lombok.Data;
import lombok.Getter;

@Getter
public class Post {

    private Long id;

    private String category;

    private String title;

    private String content;

    private Long userId;

}
