package com.practice.filmoratewithhandlerexample.storage;

import com.practice.filmoratewithhandlerexample.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreStorage {
    List<Genre> findAll();

    Optional<Genre> findById(int id);

    Genre create(Genre genre);
}

