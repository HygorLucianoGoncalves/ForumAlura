package com.hygorluciano.forumalura.controller;


import com.hygorluciano.forumalura.domain.resposta.interfaces.CrudRespostas;
import com.hygorluciano.forumalura.domain.resposta.dto.CriacaoDeRespostaDto;
import com.hygorluciano.forumalura.domain.resposta.dto.DadosRespostaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {
    private final CrudRespostas crudResposta;

    @Autowired
    public RespostaController(CrudRespostas crudResposta) {
        this.crudResposta = crudResposta;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> criaResposta(@RequestBody @Valid CriacaoDeRespostaDto dados) {
        return crudResposta.criaResposta(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosRespostaDTO>> listaResposta() {
        return crudResposta.listaResposta();
    }
}
