package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.interfaces.CrudTopico;
import com.hygorluciano.forumalura.domain.dtos.TopicoDetalhamnetoDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicoPutDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicoSemRespostaDTO;
import com.hygorluciano.forumalura.domain.dtos.TopicosPostDTO;
import com.hygorluciano.forumalura.domain.model.Topico;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final CrudTopico CrudTopico;

    public TopicoController(CrudTopico CrudTopico) {
        this.CrudTopico = CrudTopico;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> criaTopico(@RequestBody @Valid TopicosPostDTO dados) {
        return CrudTopico.criaTopico(dados);
    }

    @GetMapping
    private ResponseEntity<Page<TopicoSemRespostaDTO>> listaTopicos() {
        return CrudTopico.mostraTopicos();
    }

    @GetMapping("/{id}")
    public List<TopicoDetalhamnetoDTO> mostraTopico(@PathVariable String id) {
        return CrudTopico.mostraTopicoComRespostas(id);
    }

    @PutMapping()
    public ResponseEntity<Topico> atualizarTopico(@RequestBody @Valid TopicoPutDTO topicoPutDTO) {
        return CrudTopico.atualizarTopico(topicoPutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topico> deleteTopico(@PathVariable String id) {
        return CrudTopico.deleteTopico(id);
    }
}