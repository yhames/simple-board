package com.example.simpleboard.repository.jdbc;

import com.example.simpleboard.domain.Post;
import com.example.simpleboard.repository.PostRepository;
import com.example.simpleboard.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcPostRepository implements PostRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public long insert(Post post) {
        String sql = "INSERT INTO `POST`(`user_id`, `board_id`, `title`, `content`)"
                + " VALUES (:userId, :boardId, :title, :content)";
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, param, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public void update(Post post) {
        String sql = "UPDATE `POST` SET title=:title, content=:content, updated_date=:updatedDate WHERE id=:id";
        SqlParameterSource param = new BeanPropertySqlParameterSource(post);
        jdbcTemplate.update(sql, param);
    }

    public PostResponse findById(long id) {
        String sql = "SELECT p.id, u.name as writer, b.name as board,"
                + " p.title, p.content, p.created_date, p.updated_date, p.count_of_comments, p.count_of_views"
                + " FROM POST as p"
                + " LEFT OUTER JOIN USER as u"
                + " ON p.user_id = u.id"
                + " LEFT OUTER JOIN BOARD as b"
                + " ON p.board_id = b.id"
                + " WHERE p.id = :id";
        Map<String, Long> param = Map.of("id", id);
        return jdbcTemplate.queryForObject(sql, param, rowMapper());
    }

    public List<PostResponse> findAll() {
        String sql = "SELECT p.id, u.name as writer, b.name as board,"
                + " p.title, p.content, p.created_date, p.updated_date, p.count_of_comments, p.count_of_views"
                + " FROM POST as p"
                + " LEFT OUTER JOIN USER as u"
                + " ON p.user_id = u.id"
                + " LEFT OUTER JOIN BOARD as b"
                + " ON p.board_id = b.id"
                + " ORDER BY p.id DESC";
        return jdbcTemplate.query(sql, rowMapper());
    }

    public void delete(long id) {
        String sql = "DELETE FROM POST WHERE id=:id";
        Map<String, Long> param = Map.of("id", id);
        jdbcTemplate.update(sql, param);
    }

    private RowMapper<PostResponse> rowMapper() {
        return (rs, rowNum) -> {
            PostResponse postResponse = new PostResponse();
            postResponse.setId(rs.getLong("id"));
            postResponse.setWriter(rs.getString("writer"));
            postResponse.setBoard(rs.getString("board"));
            postResponse.setTitle(rs.getString("title"));
            postResponse.setContent(rs.getString("content"));
            postResponse.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
            postResponse.setUpdatedDate(rs.getTimestamp("updated_date").toLocalDateTime());
            postResponse.setCountOfComments(rs.getInt("count_of_comments"));
            postResponse.setCountOfViews(rs.getInt("count_of_views"));
            return postResponse;
        };
    }
}