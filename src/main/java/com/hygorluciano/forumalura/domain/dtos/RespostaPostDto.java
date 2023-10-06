package com.hygorluciano.forumalura.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record RespostaPostDto(
        @NotBlank
        String mensagem,
        @NotBlank
        String topico,
        @NotBlank
        String autor
) {
}
