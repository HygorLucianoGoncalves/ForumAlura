package com.hygorluciano.forumalura.domain.dtos;

import java.time.LocalDateTime;

public record RespostaDto(
        String mensagem,
        String autor,
        LocalDateTime dataCriacao,
        Boolean solucao
) {
}
