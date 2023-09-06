package com.hygorluciano.forumalura.domain.cursos.dto;

import jakarta.validation.constraints.*;

public record DadosCriacaoCursoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
}
