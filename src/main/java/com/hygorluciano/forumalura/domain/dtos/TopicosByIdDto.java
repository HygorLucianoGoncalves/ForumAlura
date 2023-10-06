package com.hygorluciano.forumalura.domain.dtos;

import java.time.LocalDateTime;

public record TopicosByIdDto(
        String id,
        String nome,
        LocalDateTime dataCriacao
) {
}
