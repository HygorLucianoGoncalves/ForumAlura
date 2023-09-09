package com.hygorluciano.forumalura.domain.topicos.model;

import com.hygorluciano.forumalura.domain.cursos.model.Curso;
import com.hygorluciano.forumalura.domain.resposta.model.Resposta;
import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();//a data aqui vai ser gerada na hora da criação

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(
            mappedBy = "topico",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}
