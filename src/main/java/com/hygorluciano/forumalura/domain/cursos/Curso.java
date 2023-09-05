package com.hygorluciano.forumalura.domain.cursos;


import com.hygorluciano.forumalura.domain.cursos.CursoPostDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "curso")
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
