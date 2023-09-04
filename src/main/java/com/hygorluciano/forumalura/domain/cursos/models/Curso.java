package com.hygorluciano.forumalura.domain.cursos.models;

import com.hygorluciano.forumalura.domain.cursos.dto.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "curso")
@Entity(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String categoria;

    public Curso(CursoPostDto cursoPostDto) {
        this.nome = cursoPostDto.nome();
        this.categoria = cursoPostDto.categoria();
    }
}
