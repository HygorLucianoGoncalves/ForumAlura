package com.hygorluciano.forumalura.domain.topicos.dto;

import com.hygorluciano.forumalura.domain.topicos.model.StatusTopico;
import jakarta.validation.constraints.NotBlank;

public record TopicoPutDTO(
        @NotBlank
        String id,
        String titulo,
        String mensagem,
        StatusTopico status
) {
}
