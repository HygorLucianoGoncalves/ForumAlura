package com.hygorluciano.forumalura.domain.dtos;

import java.time.LocalDateTime;

public record RespostaGetDto(
        String id,
        String mensagem,
        String topico,
        LocalDateTime dataCriacao,
        String autor,
        Boolean solucao
) {
}
