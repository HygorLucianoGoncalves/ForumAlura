package com.hygorluciano.forumalura.domain.resposta.models;

import com.hygorluciano.forumalura.domain.topicos.models.*;
import com.hygorluciano.forumalura.domain.usuarios.models.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "resposta")
@Entity(name = "resposta")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String mensagem;
    @ManyToOne
    private Topico topico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    private Usuario autor;
    private Boolean solucao = false;
}
