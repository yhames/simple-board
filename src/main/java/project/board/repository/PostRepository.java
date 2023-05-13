package project.board.repository;

import project.board.domain.Post;
import project.board.request.PostEdit;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    void save(Post post);

    Optional<Post> findById(Long postId);

    List<Post> findAll();

    void update(Long postId, PostEdit postEdit);

    void delete(Long postId);
}
