package com.hygorluciano.forumalura.domain.dtos;

import jakarta.validation.constraints.*;

public record CursoPostDto(
        @NotBlank(message = "O campo 'Nome' não pode estar vazio")
        String nome,
        @NotBlank(message = "O campo 'Categoria' não pode estar vazio")
        String categoria
) {
}
