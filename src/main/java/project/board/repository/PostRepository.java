package project.board.repository;

import project.board.domain.Post;
import project.board.request.PostCreate;
import project.board.request.PostEdit;

import java.util.List;

public interface PostRepository {

    void save(PostCreate postCreate);

    Post findById(Long postId);

    List<Post> findAll();

    void update(Long postId, PostEdit postEdit);

    void delete(Long postId);
}
