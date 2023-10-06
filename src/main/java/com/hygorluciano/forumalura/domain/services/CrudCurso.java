package com.hygorluciano.forumalura.domain.services;

import com.hygorluciano.forumalura.domain.dtos.CursoPostDto;
import com.hygorluciano.forumalura.domain.dtos.CursoDto;
import com.hygorluciano.forumalura.domain.model.Curso;
import com.hygorluciano.forumalura.domain.repositorys.CursoRepository;
import com.hygorluciano.forumalura.infra.exception.CriacaoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudCurso implements com.hygorluciano.forumalura.domain.interfaces.CrudCurso {

    private final CursoRepository cursoRepository;

    @Autowired
    public CrudCurso(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public ResponseEntity<HttpStatus> cadastraCursos(CursoPostDto dados) {

        try {
            var newCurso = new Curso(dados);

            cursoRepository.save(newCurso);

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            throw new CriacaoInvalidoException("Valores ja existe");
        }

    }

    @Override
    public ResponseEntity<List<CursoDto>> listaCurso() {

        //Faz lista de Todos os cursos
        var cursos = cursoRepository.findAll();

        // Converta a lista de cursos em uma lista de registros DadosCursoDTO
        List<CursoDto> dtos = cursos.stream()
                .map(curso -> new CursoDto(
                        curso.getId(),
                        curso.getNome(),
                        curso.getCategoria()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
}
