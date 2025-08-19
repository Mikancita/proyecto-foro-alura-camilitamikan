package com.topicos.Api.domain.topicos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        Long autor_id,
        Long curso_id
        //String respuestas
) {
}
