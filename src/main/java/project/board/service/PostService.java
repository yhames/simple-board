package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.board.domain.Post;
import project.board.repository.PostRepository;
import project.board.request.PostCreate;
import project.board.request.PostEdit;
import project.board.response.PostResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(PostCreate postCreate) {
        postRepository.save(postCreate);
    }

    public PostResponse findById(Long postId) {
        Post findPost = postRepository.findById(postId);
        return PostResponse.builder()
                .id(findPost.getId())
                .title(findPost.getTitle())
                .content(findPost.getContent())
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


}
