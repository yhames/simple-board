package com.example.simpleboard.service;

import com.example.simpleboard.domain.Post;
import com.example.simpleboard.repository.PostRepository;
import com.example.simpleboard.request.PostCreate;
import com.example.simpleboard.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponse findById(long id) {
        return postRepository.findById(id);
    }

    public List<PostResponse> findAll() {
        return postRepository.findAll();
    }

    public void insert(PostCreate postCreate) {
        Post post = Post.builder()
                .userId(postCreate.getUserId())
                .boardId(postCreate.getBoardId())
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();
        postRepository.insert(post);
    }
}
