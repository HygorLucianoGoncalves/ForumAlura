package com.hygorluciano.forumalura.domain.interfaces;

import com.hygorluciano.forumalura.domain.dtos.RespostaPostDto;
import com.hygorluciano.forumalura.domain.dtos.RespostaGetDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudRespostas {
    ResponseEntity<HttpStatus> criaResposta(RespostaPostDto dados);

    ResponseEntity<List<RespostaGetDto>> listaResposta();
}
