package com.practice.filmoratewithhandlerexample.storage.impl;

import com.practice.filmoratewithhandlerexample.exception.NotFoundException;
import com.practice.filmoratewithhandlerexample.model.Genre;
import com.practice.filmoratewithhandlerexample.storage.GenreStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GenreDbStorage implements GenreStorage {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> findAll() {
        String sql = "select * from genres";
        return jdbcTemplate.query(sql, this::rowMapper);
    }

    @Override
    public Genre findById(int id) {
        String sql = "select * from genres where id = ?";
        return jdbcTemplate.query(sql, this::rowMapper, id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Жанр с id=%s не найден".formatted(id))); // выброс исключения
    }

    @Override
    public Genre create(Genre genre) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("genres")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> map = Map.of("name", genre.getName());
        int id = insert.executeAndReturnKey(map).intValue();
        genre.setId(id);
        return genre;
    }

    private Genre rowMapper(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Genre(id, name);
    }
}

