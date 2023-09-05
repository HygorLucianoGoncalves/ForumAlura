package com.hygorluciano.forumalura.domain.topicos;

import com.hygorluciano.forumalura.domain.cursos.Curso;
import com.hygorluciano.forumalura.domain.resposta.Resposta;
import com.hygorluciano.forumalura.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();//a data aqui vai ser gerada na hora da criação

    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}
