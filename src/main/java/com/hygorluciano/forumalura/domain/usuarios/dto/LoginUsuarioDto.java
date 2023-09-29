package com.hygorluciano.forumalura.domain.usuarios.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginUsuarioDto(

        String email,

        String senha
) {
}
