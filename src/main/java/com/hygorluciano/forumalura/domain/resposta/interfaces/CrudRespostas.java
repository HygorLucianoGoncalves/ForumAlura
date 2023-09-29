package com.hygorluciano.forumalura.domain.resposta.interfaces;

import com.hygorluciano.forumalura.domain.resposta.dto.CriacaoDeRespostaDto;
import com.hygorluciano.forumalura.domain.resposta.dto.DadosRespostaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudRespostas {
    ResponseEntity<HttpStatus> criaResposta(CriacaoDeRespostaDto dados);

    ResponseEntity<List<DadosRespostaDTO>> listaResposta();
}
