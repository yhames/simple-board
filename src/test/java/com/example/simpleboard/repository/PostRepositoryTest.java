package com.example.simpleboard.repository;

import com.example.simpleboard.domain.Post;
import com.example.simpleboard.response.PostResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("insert_findAll")
    void insert_findAll() {
        Post post = Post.builder()
                .userId(1)
                .boardId(1)
                .title("title")
                .content("content")
                .build();
        postRepository.insert(post);

        List<PostResponse> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("insert_findById")
    void insert_findById() {
        Post post = Post.builder()
                .userId(1)
                .boardId(1)
                .title("title")
                .content("content")
                .build();
        long id = postRepository.insert(post);

        PostResponse postResponse = postRepository.findById(id);
        assertThat(postResponse.getId()).isEqualTo(id);
        assertThat(postResponse.getTitle()).isEqualTo(post.getTitle());
        assertThat(postResponse.getContent()).isEqualTo(post.getContent());
    }

    @Test
    @DisplayName("insert_update")
    void insert_update() {
        Post post = Post.builder()
                .userId(1)
                .boardId(1)
                .title("title")
                .content("content")
                .build();
        long id = postRepository.insert(post);

        Post update = Post.builder()
                .id(id)
                .userId(1)
                .boardId(1)
                .title("title-mod")
                .content("content-mod")
                .build();
        postRepository.update(update);

        PostResponse findPost = postRepository.findById(id);

        assertThat(findPost.getTitle()).isEqualTo(update.getTitle());
        assertThat(findPost.getContent()).isEqualTo(update.getContent());
    }
}