package com.hygorluciano.forumalura.domain.resposta.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RespostaDTO(
        String mensagem,
        String autor,
        LocalDateTime dataCriacao,
        Boolean solucao
) {
}
