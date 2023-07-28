package com.example.simpleboard.repository;

import com.example.simpleboard.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Post> findAll() {
        String sql = "SELECT p.id, u.name as writer, b.name as board,"
                + " p.title, p.content, p.created_date, p.updated_date, p.count_of_comments, p.count_of_views"
                + " FROM POST as p"
                + " LEFT OUTER JOIN USER as u"
                + " ON p.user_id = u.id"
                + " LEFT OUTER JOIN BOARD as b"
                + " ON p.board_id = b.id";
        return jdbcTemplate.query(sql, rowMapper());
    }

    private RowMapper<Post> rowMapper() {
        return (rs, rowNum) -> {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setWriter(rs.getString("writer"));
            post.setBoard(rs.getString("board"));
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
