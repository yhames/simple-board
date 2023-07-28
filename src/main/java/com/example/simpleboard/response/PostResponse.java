package com.example.simpleboard.response;

import com.example.simpleboard.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private long id;

    private String writer;

    private String board;

    private String title;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private int countOfComments;

    private int countOfViews;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.writer = post.getWriter();
        this.board = post.getBoard();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdDate = post.getCreatedDate();
        this.updatedDate = post.getUpdatedDate();
        this.countOfComments = post.getCountOfComments();
        this.countOfViews = post.getCountOfViews();
    }

}
