package com.hygorluciano.forumalura.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioPutDto(
        @NotBlank
        String id,
        String nome,
        @Email
        String email,
        String senha

) {
}
