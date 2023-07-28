package com.example.simpleboard.repository;

import com.example.simpleboard.domain.Post;

import java.util.List;

public interface PostRepository {

    List<Post> findAll();

}
