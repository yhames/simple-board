package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.board.domain.Post;
import project.board.repository.MemoryPostRepository;
import project.board.repository.PostRepository;
import project.board.request.PostCreate;
import project.board.request.PostEdit;
import project.board.response.PostResponse;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(PostCreate postCreate) {
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();
        postRepository.save(post);
    }

    public PostResponse findById(Long postId) {
        Optional<Post> findPost = postRepository.findById(postId);
        Post post = findPost.orElseThrow(() -> new NoSuchElementException());
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public List<PostResponse> findAll() {
        return postRepository.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public void update(Long postId, PostEdit postEdit) {
        postRepository.update(postId, postEdit);
    }

    public void delete(Long postId) {
        postRepository.delete(postId);
    }
}
