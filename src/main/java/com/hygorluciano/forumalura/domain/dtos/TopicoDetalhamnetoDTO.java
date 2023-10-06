package com.hygorluciano.forumalura.domain.dtos;

import com.hygorluciano.forumalura.domain.dtos.RespostaDto;
import com.hygorluciano.forumalura.domain.model.StatusTopico;

import java.time.LocalDateTime;
import java.util.List;

public record TopicoDetalhamnetoDTO(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso,
        List<RespostaDto> respostas) {

}
