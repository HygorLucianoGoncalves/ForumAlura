package com.hygorluciano.forumalura.domain.model;


import com.hygorluciano.forumalura.domain.dtos.CursoPostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nome;

    private String categoria;

    public Curso(CursoPostDto dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }
}
