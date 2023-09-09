package com.hygorluciano.forumalura.domain.topicos.dto;

import com.hygorluciano.forumalura.domain.resposta.dto.RespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.model.StatusTopico;

import java.time.LocalDateTime;
import java.util.List;

public record TopicoDetalhamnetoDTO(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso,
        List<RespostaDTO> respostas) {

}
