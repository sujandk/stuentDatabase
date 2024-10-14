package com.example.demo.student;

import jakarta.validation.constraints.NotNull;

public record StudentDto(
        @NotNull
        String name,
        String email,
        @NotNull
        String LastName,
        Integer schoolId
) {
}
