package com.hygorluciano.forumalura.domain.topicos;

import com.hygorluciano.forumalura.domain.resposta.Resposta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record TopicoDetalhamnetoDto(String id,
                                    String titulo,
                                    String mensagem,
                                    LocalDateTime dataCriacao,
                                    StatusTopico status,
                                    String autor,
                                    String curso,
                                    List<Resposta> respostas) {

    public TopicoDetalhamnetoDto(Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getMensagem(),topico.getDataCriacao(),topico.getStatus(),topico.getAutor().getId(),topico.getCurso().getId(),topico.getRespostas());

    }
}
