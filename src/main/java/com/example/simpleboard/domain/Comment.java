package com.example.simpleboard.domain;

import lombok.Getter;

@Getter
public class Comment {

    private Long id;

    private String content;

    private Long postId;

    private Long userId;

}
