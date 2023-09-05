package com.hygorluciano.forumalura.domain.resposta;



import com.hygorluciano.forumalura.domain.topicos.Topico;
import com.hygorluciano.forumalura.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "resposta")
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
