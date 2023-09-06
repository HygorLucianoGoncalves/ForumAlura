package com.hygorluciano.forumalura.domain.resposta.models;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.hygorluciano.forumalura.domain.topicos.models.Topico;
import com.hygorluciano.forumalura.domain.usuarios.models.Usuario;
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
    private Topico topico;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario autor;

    private Boolean solucao = false;
}