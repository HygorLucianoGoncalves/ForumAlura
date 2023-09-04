package com.hygorluciano.forumalura.controller;

import com.hygorluciano.forumalura.domain.cursos.dto.*;
import com.hygorluciano.forumalura.domain.cursos.models.*;
import com.hygorluciano.forumalura.domain.cursos.repository.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;
    @PostMapping
    public ResponseEntity postCurso(@RequestBody @Valid CursoPostDto cursoPostDto){
        var newCurso = new Curso(cursoPostDto);
        cursoRepository.save(newCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCurso);
    }
}
