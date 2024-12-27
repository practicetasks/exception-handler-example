package com.practice.filmoratewithhandlerexample.service;

import com.practice.filmoratewithhandlerexample.model.Genre;
import com.practice.filmoratewithhandlerexample.storage.GenreStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreStorage genreStorage;

    public List<Genre> findAll() {
        log.debug("Получение списка жанров");
        return genreStorage.findAll();
    }

    public Genre findById(int id) {
        log.debug("Получение жанра по идентификатору {}", id);
        return genreStorage.findById(id);
    }

    public Genre create(Genre genre) {
        log.debug("Создание жанра");
        return genreStorage.create(genre);
    }
}
