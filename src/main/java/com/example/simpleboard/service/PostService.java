package com.example.simpleboard.service;

import com.example.simpleboard.domain.Post;
import com.example.simpleboard.repository.PostRepository;
import com.example.simpleboard.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostResponse::new).toList();
    }

}
