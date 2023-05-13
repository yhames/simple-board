package project.board.repository;

import org.springframework.stereotype.Repository;
import project.board.domain.Post;
import project.board.request.PostCreate;
import project.board.request.PostEdit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository // TODO: 데이터베이스 결정 후 바꿀 예정
public class MemoryPostRepository implements PostRepository {

    private static final Map<Long, Post> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    public void save(Post post) {
        post.createId(++sequence);
        store.put(post.getId(), post);
    }

    public Post findById(Long postId) {
        return store.get(postId);
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long postId, PostEdit postEdit) {
        Post findPost = store.get(postId);
        findPost.changePost(postEdit.getTitle(), postEdit.getContent());
    }

    public void delete(Long postId) {
        store.remove(postId);
    }
}
