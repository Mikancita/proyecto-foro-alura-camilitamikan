package com.topicos.Api.domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name="topico")
@Entity(name="Topico")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo ;
    private String mensaje ;
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status ;
    private Long autor_id ;
    private Long curso_id ;
    //private String respuestas ;
    private boolean activo;

    public Topico(DatosRegistroTopico datos){
        this.id=null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = datos.fechaCreacion();
        this.status = datos.status();
        this.autor_id = datos.autor_id();
        this.curso_id = datos.curso_id();
        //this.respuestas = datos.respuestas();
    }
    public void actualizarInformaciones(@Valid DatosActualizacionTopico datos ){
        if(datos.titulo()!=null){
            this.titulo = datos.titulo();
        }
        if(datos.mensaje()!=null){
            this.mensaje = datos.mensaje();
        }
//        if(datos.respuestas()!=null){
//            this.respuestas = datos.respuestas();
//        }
    }


    public void inactivar() {
        this.activo = false;
    }
}
