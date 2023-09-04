package com.hygorluciano.forumalura.domain.usuarios.models;

import com.hygorluciano.forumalura.domain.usuarios.dto.*;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "usuario")
@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(UsuarioPostDto usuarioPostDto) {
        this.nome = usuarioPostDto.nome();
        this.email = usuarioPostDto.email();
        this.senha = usuarioPostDto.senha();
    }
}
