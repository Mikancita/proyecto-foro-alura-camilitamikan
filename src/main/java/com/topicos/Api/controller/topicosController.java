package com.topicos.Api.controller;
import com.topicos.Api.domain.topicos.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
//import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class topicosController {
    @Autowired
    private TopícosRepository repository;
    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder){
        var topico = new Topico(datos);
        repository.save(new Topico(datos));
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopicos(topico));
    }
    @GetMapping
    public ResponseEntity <Page<DatosListaTopicos>> listar(@PageableDefault(size =10, sort = {"titulo"})Pageable paginacion){
        var page = repository.findAllByActivoTrue(paginacion).map(DatosListaTopicos::new);
        return ResponseEntity.ok(page);

    }
    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarInformaciones(datos);
        return ResponseEntity.ok(new DatosDetalleTopicos(topico));
    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.inactivar();
        return ResponseEntity.noContent().build();
    }
//    @GetMapping("/{id}")
//    public ResponseEntity detallar(@PathVariable Long id){
//        var topico = repository.getReferenceById(id);
//        return ResponseEntity.ok(new DatosDetalleTopicos(topico));
//    }
    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        if (!repository.existsByIdAndActivoTrue(id)) {
            return ResponseEntity.notFound().build(); // Línea añadida
        }
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopicos(topico));
    }

}
