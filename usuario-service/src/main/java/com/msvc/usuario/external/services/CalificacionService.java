package com.msvc.usuario.external.services;

import com.msvc.usuario.entities.Calificacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface CalificacionService {
    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(Calificacion calificacion);
    @PutMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Calificacion> actualizarCalificacion(Calificacion calificacion, @PathVariable String calificacionId);
    @DeleteMapping("/calificaciones/{calificacionId}")
    public void eliminarCalificacion(@PathVariable String calificacionId);
    @GetMapping("/calificaciones/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorUsuarioId(@PathVariable String usuarioId);
}
