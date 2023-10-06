package com.hygorluciano.forumalura.controller;


import com.hygorluciano.forumalura.domain.interfaces.CrudRespostas;
import com.hygorluciano.forumalura.domain.dtos.RespostaPostDto;
import com.hygorluciano.forumalura.domain.dtos.RespostaGetDto;
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
    public ResponseEntity<HttpStatus> criaResposta(@RequestBody @Valid RespostaPostDto dados) {
        return crudResposta.criaResposta(dados);
    }

    @GetMapping
    public ResponseEntity<List<RespostaGetDto>> listaResposta() {
        return crudResposta.listaResposta();
    }
}
