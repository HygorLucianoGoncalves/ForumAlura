package com.hygorluciano.forumalura.domain.cursos.service;

import com.hygorluciano.forumalura.domain.cursos.dto.DadosCriacaoCursoDTO;
import com.hygorluciano.forumalura.domain.cursos.dto.DadosCursoDTO;
import com.hygorluciano.forumalura.domain.cursos.model.Curso;
import com.hygorluciano.forumalura.domain.cursos.repository.CursoRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudCursos {

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity cadastraCursos(DadosCriacaoCursoDTO dados) {

        try {
            // Cria um novo tópico com os dados fornecidos
            var newCurso = new Curso(dados);

            // Salva o novo tópico no repositório
            cursoRepository.save(newCurso);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            throw new CriacaoInvalidoException("Valores ja existe");
        }

    }

    public ResponseEntity listaCurso() {
        //Faz lista de Todos os cursos
        var cursos = cursoRepository.findAll();

        // Converta a lista de cursos em uma lista de registros DadosCursoDTO
        List<DadosCursoDTO> dtos = cursos.stream()
                .map(curso -> new DadosCursoDTO(curso.getId(),curso.getNome(), curso.getCategoria()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
