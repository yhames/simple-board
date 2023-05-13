package project.board.domain;

import lombok.*;


@Getter
public class Post {

    private Long id;
    private String title;
    private String content;

    @Builder
    public Post(Long id, String title, String content) {    // 빌더패턴 적용
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void changePost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}