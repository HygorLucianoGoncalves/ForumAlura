package com.hygorluciano.forumalura.domain.topicos;

import com.hygorluciano.forumalura.domain.resposta.Resposta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record TopicosPostDto(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        String autor,
        String curso

) {
}
