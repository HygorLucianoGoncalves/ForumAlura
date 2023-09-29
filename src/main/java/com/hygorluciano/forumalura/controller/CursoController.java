package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.cursos.interfaces.CrudCurso;
import com.hygorluciano.forumalura.domain.cursos.dto.DadosCriacaoCursoDTO;
import com.hygorluciano.forumalura.domain.cursos.dto.DadosCursoDTO;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CrudCurso crudCurso;

    @Autowired
    public CursoController(CrudCurso crudCurso) {
        this.crudCurso = crudCurso;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> postCurso(@RequestBody @Valid DadosCriacaoCursoDTO cursoPostDto) {
        return crudCurso.cadastraCursos(cursoPostDto);
    }

    @GetMapping
    public ResponseEntity<List<DadosCursoDTO>> cursos() {
        return crudCurso.listaCurso();
    }

}
