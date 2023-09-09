package com.hygorluciano.forumalura.domain.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUsuariosDTO(
        String id,
        @NotBlank(message = "O campo 'Email' não pode estar vazio")
        @Email(message = "O campo 'Email' deve ser um endereço de email válido")
        String nome,
        String email
) {
}
