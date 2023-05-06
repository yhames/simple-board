package project.board.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

//@Entity   // TODO : Spring Data JPA 공부하고 사용 예정
@Getter
@Setter
public class Post {

    private Long id;
    private String title;
    private String content;

    @Builder
    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}