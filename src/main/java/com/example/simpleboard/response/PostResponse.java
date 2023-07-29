package com.example.simpleboard.response;

import com.example.simpleboard.domain.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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

    public PostResponse(Post post, String writer, String board) {
        this.id = post.getId();
        this.writer = writer;
        this.board = board;
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdDate = post.getCreatedDate();
        this.updatedDate = post.getUpdatedDate();
        this.countOfComments = post.getCountOfComments();
        this.countOfViews = post.getCountOfViews();
    }

}
