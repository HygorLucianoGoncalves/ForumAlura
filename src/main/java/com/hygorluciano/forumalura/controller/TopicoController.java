package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.topicos.dto.TopicoDetalhamnetoDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoPutDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicoSemRespostaDTO;
import com.hygorluciano.forumalura.domain.topicos.dto.TopicosPostDTO;
import com.hygorluciano.forumalura.domain.topicos.model.Topico;
import com.hygorluciano.forumalura.domain.topicos.service.CrudTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private CrudTopico crudTopico;

    @PostMapping
    public ResponseEntity criaTopico(@RequestBody @Valid TopicosPostDTO dados){
        return crudTopico.criaTopico(dados);
    }

    @GetMapping
    private ResponseEntity<Page<TopicoSemRespostaDTO>> listaTopicos(Pageable pageable){
        return crudTopico.mostraTopicos(pageable);
    }

    @GetMapping("/{id}")
    public List<TopicoDetalhamnetoDTO> mostraTopico(@PathVariable String id) {
        return crudTopico.mostraTopicoComRespostas(id);
    }

    @PutMapping()
    public ResponseEntity<Topico> atualizarTopico(@RequestBody @Valid TopicoPutDTO topicoPutDTO){
       return crudTopico.atualizarTopico(topicoPutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topico> deleteTopico(@PathVariable String id){
        return crudTopico.deleteTopico(id);
    }

}