package com.hygorluciano.forumalura.domain.topicos.dto;

import java.time.LocalDateTime;

public record PesquisaTopicosById(
        String id,
        String nome,
        LocalDateTime dataCriacao
) {
}
