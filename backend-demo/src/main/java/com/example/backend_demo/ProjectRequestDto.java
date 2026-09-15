package com.example.backend_demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectRequestDto {

    @NotBlank(message = "Titulli nuk mund të jetë i zbrazët!")
    @Size(min = 3, max = 100, message = "Titulli duhet të ketë midis 3 dhe 100 karaktere!")
    private String title;

    @NotBlank(message = "Statusi është i detyrueshëm!")
    private String status;
}