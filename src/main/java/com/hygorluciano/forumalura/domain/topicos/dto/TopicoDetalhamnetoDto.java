package com.hygorluciano.forumalura.domain.topicos.dto;

import com.hygorluciano.forumalura.domain.resposta.dto.DadosRespostaDTO;
import com.hygorluciano.forumalura.domain.resposta.dto.RespostaDTO;
import com.hygorluciano.forumalura.domain.resposta.models.Resposta;
import com.hygorluciano.forumalura.domain.topicos.models.Topico;
import com.hygorluciano.forumalura.domain.topicos.models.StatusTopico;

import java.time.LocalDateTime;
import java.util.List;

public record TopicoDetalhamnetoDto(
        String id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso,
        List<RespostaDTO> respostas) {

}
