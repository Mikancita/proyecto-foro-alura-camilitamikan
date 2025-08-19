package com.topicos.Api.domain.topicos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull @Future LocalDateTime fechaCreacion,
        @NotNull Status status,
        @NotNull Long autor_id,
        @NotNull Long curso_id
        //String respuestas
        ) {
}
