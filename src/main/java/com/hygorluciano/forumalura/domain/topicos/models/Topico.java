package com.hygorluciano.forumalura.domain.topicos.models;

import com.hygorluciano.forumalura.domain.cursos.models.*;
import com.hygorluciano.forumalura.domain.resposta.models.*;
import com.hygorluciano.forumalura.domain.topicos.*;
import com.hygorluciano.forumalura.domain.usuarios.models.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "topico")
@Entity(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;
    @OneToMany
    private List<Resposta> respostas = new ArrayList<>();
}
