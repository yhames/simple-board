package com.example.simpleboard.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequest {

    private long userId;

    private long boardId;

    private String title;

    private String content;


    @Builder
    public PostRequest(long userId, long boardId, String title, String content) {
        this.userId = userId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
