package com.hygorluciano.forumalura.domain.resposta.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.hygorluciano.forumalura.domain.topicos.model.Topico;
import com.hygorluciano.forumalura.domain.usuarios.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Topico topico;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucao = false;

    public Resposta(String mensagem, Topico topico, Usuario autor) {
        this.mensagem = mensagem;
        this.topico = topico;
        this.autor = autor;
    }
}
