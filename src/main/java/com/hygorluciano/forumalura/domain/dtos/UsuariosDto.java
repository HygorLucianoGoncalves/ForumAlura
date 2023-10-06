package com.hygorluciano.forumalura.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuariosDto(
        String id,
        String nome,
        @NotBlank(message = "O campo 'Email' não pode estar vazio")
        @Email(message = "O campo 'Email' deve ser um endereço de email válido")
        String email
) {
}
