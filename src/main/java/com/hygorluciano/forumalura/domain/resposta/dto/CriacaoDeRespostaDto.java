package com.hygorluciano.forumalura.domain.resposta.dto;

import jakarta.validation.constraints.NotBlank;

public record CriacaoDeRespostaDto(
        @NotBlank
        String mensagem,
        @NotBlank
        String topico,
        @NotBlank
        String autor
) {
}
