package com.example.simpleboard.repository;

import com.example.simpleboard.domain.Post;
import com.example.simpleboard.response.PostResponse;

import java.util.List;

public interface PostRepository {

    long insert(Post post);

    void update(Post post);

    PostResponse findById(long id);

    List<PostResponse> findAll();

    void delete(long id);

}
