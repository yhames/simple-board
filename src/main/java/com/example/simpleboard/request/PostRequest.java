package com.example.simpleboard.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostRequest {

    private long userId;

    private long boardId;

    private String title;

    private String content;

    public PostRequest() {
    }

    @Builder
    public PostRequest(long userId, long boardId, String title, String content) {
        this.userId = userId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
