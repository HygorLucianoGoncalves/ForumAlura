package com.hygorluciano.forumalura.domain.usuarios;


import com.hygorluciano.forumalura.domain.usuarios.UsuarioPostDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
