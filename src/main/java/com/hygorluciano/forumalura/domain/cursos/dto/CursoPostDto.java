package com.hygorluciano.forumalura.domain.cursos.dto;

import jakarta.validation.constraints.*;

public record CursoPostDto(
        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
}
