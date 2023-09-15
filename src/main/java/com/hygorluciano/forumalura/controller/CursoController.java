package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.cursos.dto.DadosCriacaoCursoDTO;
import com.hygorluciano.forumalura.domain.cursos.repository.CursoRepository;
import com.hygorluciano.forumalura.domain.cursos.service.CrudCursos;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CrudCursos crudCursos;
    @PostMapping
    public ResponseEntity postCurso(@RequestBody @Valid DadosCriacaoCursoDTO cursoPostDto){
        return crudCursos.cadastraCursos(cursoPostDto);
    }

    @GetMapping
    public ResponseEntity cursos(){
        return crudCursos.listaCurso();
    }

}
