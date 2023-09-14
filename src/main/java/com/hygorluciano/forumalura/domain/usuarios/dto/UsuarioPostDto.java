package com.hygorluciano.forumalura.domain.usuarios.dto;

import com.hygorluciano.forumalura.domain.usuarios.model.UsuarioRole;
import jakarta.validation.constraints.*;

public record UsuarioPostDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        String senha,
        UsuarioRole role

) {
}
