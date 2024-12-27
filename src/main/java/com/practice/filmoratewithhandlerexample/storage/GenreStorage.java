package com.practice.filmoratewithhandlerexample.storage;

import com.practice.filmoratewithhandlerexample.model.Genre;

import java.util.List;

public interface GenreStorage {
    List<Genre> findAll();

    Genre findById(int id);

    Genre create(Genre genre);
}

