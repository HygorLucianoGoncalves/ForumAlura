package com.hygorluciano.forumalura.domain.cursos.interfaces;

import com.hygorluciano.forumalura.domain.cursos.dto.DadosCriacaoCursoDTO;
import com.hygorluciano.forumalura.domain.cursos.dto.DadosCursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudCurso {
    ResponseEntity<HttpStatus> cadastraCursos(DadosCriacaoCursoDTO dados);

    ResponseEntity<List<DadosCursoDTO>> listaCurso();
}
