package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.resposta.models.Resposta;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicosPostDto;
import com.hygorluciano.forumalura.domain.topicos.models.Topico;
import com.hygorluciano.forumalura.domain.topicos.repository.TopicosRespository;
import com.hygorluciano.forumalura.domain.topicos.service.CrudTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private CrudTopico crudTopico;

    @Autowired
    private TopicosRespository topicosRespository;

    @PostMapping("/create")
    public ResponseEntity criaTopico(@RequestBody @Valid TopicosPostDto dados){
        return crudTopico.criaTopico(dados);

    }

    @GetMapping
    public ResponseEntity mostraTopico() {
        return crudTopico.mostraTopico();
    }

}