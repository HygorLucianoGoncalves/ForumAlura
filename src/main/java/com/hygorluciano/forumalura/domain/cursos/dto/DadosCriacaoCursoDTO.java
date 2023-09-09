package com.hygorluciano.forumalura.domain.cursos.dto;

import jakarta.validation.constraints.*;

public record DadosCriacaoCursoDTO(
        @NotBlank(message = "O campo 'Nome' não pode estar vazio")
        String nome,
        @NotBlank(message = "O campo 'Categoria' não pode estar vazio")
        String categoria
) {
}
