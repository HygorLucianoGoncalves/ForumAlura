package com.hygorluciano.forumalura.domain.dtos;

import com.hygorluciano.forumalura.domain.model.StatusTopico;

import java.time.LocalDateTime;

public record TopicoSemRespostaDTO(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {

}
