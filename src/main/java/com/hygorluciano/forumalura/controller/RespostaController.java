package com.hygorluciano.forumalura.controller;


import com.hygorluciano.forumalura.domain.resposta.dto.CriacaoDeRespostaDto;
import com.hygorluciano.forumalura.domain.resposta.service.CrudResposta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private CrudResposta crudResposta;

    @PostMapping
    public ResponseEntity criaResposta(@RequestBody @Valid CriacaoDeRespostaDto dados){
        return crudResposta.criaResposta(dados);
    }

    @GetMapping
    public ResponseEntity listaResposta(){
        return crudResposta.listaResposta();
    }


}
