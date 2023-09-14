package com.hygorluciano.forumalura.domain.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AtualizarUsuarioDto(
        @NotBlank
        String id,
        String nome,
        @Email
        String email,
        String senha

) {
}
