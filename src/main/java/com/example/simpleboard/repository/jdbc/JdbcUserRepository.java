package com.example.simpleboard.repository.jdbc;

import com.example.simpleboard.domain.User;
import com.example.simpleboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findByName(String name) {
        String sql = "SELECT id, name, password"
                + " FROM USER"
                + " WHERE name=:name";
        Map<String, String> param = Map.of("name", name);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, param, rowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Optional<User> findById(long id) {
        String sql = "SELECT id, name, password"
                + " FROM USER"
                + " WHERE id=:id";
        Map<String, Long> param = Map.of("id", id);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, param, rowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    private static RowMapper<User> rowMapper() {
        return (rs, rowNum) -> User.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .password(rs.getString("password"))
                .build();
    }
}
