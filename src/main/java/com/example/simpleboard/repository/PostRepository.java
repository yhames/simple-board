package com.example.simpleboard.repository;

import com.example.simpleboard.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Post> findAll() {
        String sb = "SELECT p.id as post_id, u.name as writer, category," +
                " title, p.content as content," +
                " created_date, updated_date," +
                " COUNT(c.id) as count_of_comments, count_of_views" +
                " FROM POST as p" +
                " LEFT OUTER JOIN USER as u" +
                " ON p.user_id = u.id" +
                " LEFT OUTER JOIN COMMENT as c" +
                " ON p.id = c.post_id" +
                " GROUP BY p.id";
        return jdbcTemplate.query(sb, rowMapper());
    }

    private RowMapper<Post> rowMapper() {
        return (rs, rowNum) -> {
            Post post = new Post();
            post.setId(rs.getLong("post_id"));
            post.setWriter(rs.getString("writer"));
            post.setCategory(rs.getString("category"));
            post.setTitle(rs.getString("title"));
            post.setContent(rs.getString("content"));
            post.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
            post.setUpdatedDate(rs.getTimestamp("updated_date").toLocalDateTime());
            post.setCountOfComments(rs.getInt("count_of_comments"));
            post.setCountOfViews(rs.getInt("count_of_views"));
            return post;
        };
    }
}
