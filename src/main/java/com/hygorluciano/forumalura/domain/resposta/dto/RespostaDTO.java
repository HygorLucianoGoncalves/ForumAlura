package com.hygorluciano.forumalura.domain.resposta.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RespostaDTO(
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        Boolean solucao
) {
}
