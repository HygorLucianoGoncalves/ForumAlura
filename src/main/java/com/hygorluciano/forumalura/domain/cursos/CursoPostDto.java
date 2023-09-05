package com.hygorluciano.forumalura.domain.cursos;

import jakarta.validation.constraints.*;

public record CursoPostDto(
        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
}
