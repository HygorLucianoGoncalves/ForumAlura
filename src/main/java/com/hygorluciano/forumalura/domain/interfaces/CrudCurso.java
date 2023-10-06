package com.hygorluciano.forumalura.domain.interfaces;

import com.hygorluciano.forumalura.domain.dtos.CursoPostDto;
import com.hygorluciano.forumalura.domain.dtos.CursoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudCurso {
    ResponseEntity<HttpStatus> cadastraCursos(CursoPostDto dados);

    ResponseEntity<List<CursoDto>> listaCurso();
}
