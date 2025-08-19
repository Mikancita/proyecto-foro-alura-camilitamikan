package com.topicos.Api.domain.topicos;

import java.time.LocalDateTime;

public record DatosListaTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        Long autor_id,
        Long curso_id
        //String respuestas
) {
    public DatosListaTopicos(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor_id(),
                topico.getCurso_id()
                //topico.getRespuestas()
        );
    }
}
