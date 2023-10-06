package com.hygorluciano.forumalura.domain.dtos;

import com.hygorluciano.forumalura.domain.model.UsuarioRole;
import jakarta.validation.constraints.*;

public record UsuarioPostDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        String senha,
        @NotNull
        UsuarioRole role

) {
}
