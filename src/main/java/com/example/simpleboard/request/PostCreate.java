package com.example.simpleboard.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreate {

    private long userId;

    @NotNull
    private Long boardId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public PostCreate() {
    }

    @Builder
    public PostCreate(long userId, long boardId, String title, String content) {
        this.userId = userId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }
}
