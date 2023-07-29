package com.example.simpleboard.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Post {

    private long id;

    private long userId;

    private long boardId;

    private String title;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private int countOfComments;

    private int countOfViews;

    @Builder
    public Post(long id, long userId, long boardId,
                String title, String content, LocalDateTime createdDate,
                int countOfComments, int countOfViews) {
        this.id = id;
        this.userId = userId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = LocalDateTime.now();
        this.countOfComments = countOfComments;
        this.countOfViews = countOfViews;
    }
}
