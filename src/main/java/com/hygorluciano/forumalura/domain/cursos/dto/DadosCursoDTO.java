package com.hygorluciano.forumalura.domain.cursos.dto;

import com.hygorluciano.forumalura.domain.cursos.models.Curso;

import java.util.List;

public record DadosCursoDTO(
        String id,
        String nome,
        String categoria
) {
}
