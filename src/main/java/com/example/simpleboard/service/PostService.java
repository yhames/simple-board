package com.example.simpleboard.service;

import com.example.simpleboard.domain.Post;
import com.example.simpleboard.repository.PostRepository;
import com.example.simpleboard.request.PostRequest;
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

    public void insert(PostRequest postRequest) {
        Post post = Post.builder()
                .userId(postRequest.getUserId())
                .boardId(postRequest.getBoardId())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .build();
        postRepository.insert(post);
    }
}
