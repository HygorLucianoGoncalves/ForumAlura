package com.hygorluciano.forumalura.domain.dtos;

import com.hygorluciano.forumalura.domain.model.StatusTopico;
import jakarta.validation.constraints.NotBlank;

public record TopicoPutDTO(
        @NotBlank
        String id,
        String titulo,
        String mensagem,
        StatusTopico status
) {
}
