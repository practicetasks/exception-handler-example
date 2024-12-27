package com.practice.filmoratewithhandlerexample.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Genre {
    private int id;

    @NotBlank(message = "Название жанра не может быть пустым")
    private String name;
}
