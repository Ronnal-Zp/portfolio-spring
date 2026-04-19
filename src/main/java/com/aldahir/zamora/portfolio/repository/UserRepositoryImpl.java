package com.aldahir.zamora.portfolio.repository;

import com.aldahir.zamora.portfolio.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userRowMapper = ((rs, rowNum) -> {
       User user = new User();
       user.setId(rs.getLong("id"));
       user.setUsername(rs.getString("username"));
       user.setPassword(rs.getString("password"));
       user.setEnabled(rs.getBoolean("enabled"));
       return user;
    });

    @Override
    public Optional<User> findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, userRowMapper, username));
        } catch (EmptyResultDataAccessException e) {
            return  Optional.empty();
        }
    }

}
