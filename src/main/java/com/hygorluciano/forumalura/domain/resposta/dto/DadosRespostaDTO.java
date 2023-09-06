package com.hygorluciano.forumalura.domain.resposta.dto;

import com.hygorluciano.forumalura.domain.resposta.models.Resposta;

import java.time.LocalDateTime;

public record DadosRespostaDTO(
        String id,
        String mensagem,
        String topico,
        LocalDateTime dataCriacao,
        String autor,
        Boolean solucao


){
    public DadosRespostaDTO(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getTopico().getId(),
                resposta.getDataCriacao(),
                resposta.getAutor().getId(),
                resposta.getSolucao());
    }
}
