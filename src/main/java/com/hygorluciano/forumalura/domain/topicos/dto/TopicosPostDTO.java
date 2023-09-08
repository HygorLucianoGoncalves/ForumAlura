package com.hygorluciano.forumalura.domain.topicos.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicosPostDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso

) {
}
