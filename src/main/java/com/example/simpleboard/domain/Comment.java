package com.example.simpleboard.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {

    private Long id;

    private String content;

    private Long postId;

    private Long userId;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

}
