package com.practice.filmoratewithhandlerexample.controller;

import com.practice.filmoratewithhandlerexample.model.Genre;
import com.practice.filmoratewithhandlerexample.service.GenreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/genres")
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public List<Genre> findAll() {
        log.debug("GET /genres");
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public Genre findById(@PathVariable int id) {
        log.debug("GET /genres/{}", id);
        return genreService.findById(id);
    }

    // СОГЛАСНО ТЗ, ЭНДПОИНТА БЫТЬ НЕ ДОЛЖНО. ПРИВЕДЕНО ИСКЛЮЧИТЕЛЬНО ДЛЯ ПРИМЕРА
    @PostMapping
    public Genre create(@Valid @RequestBody Genre genre) {
        log.debug("POST /genres {}", genre);
        return genreService.create(genre);
    }
}

