package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.cursos.CursoRepository;
import com.hygorluciano.forumalura.domain.resposta.Resposta;
import com.hygorluciano.forumalura.domain.resposta.RespostaRepository;
import com.hygorluciano.forumalura.domain.topicos.CriacaoDeTopico;
import com.hygorluciano.forumalura.domain.topicos.Topico;
import com.hygorluciano.forumalura.domain.topicos.TopicoDetalhamnetoDto;
import com.hygorluciano.forumalura.domain.topicos.TopicosPostDto;
import com.hygorluciano.forumalura.domain.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private CriacaoDeTopico topico;

    @PostMapping("/create")
    public ResponseEntity criaTopico(@RequestBody @Valid TopicosPostDto dados){
        var dto = topico.criaTopico(dados);
        return ResponseEntity.ok(dto);

    }

}