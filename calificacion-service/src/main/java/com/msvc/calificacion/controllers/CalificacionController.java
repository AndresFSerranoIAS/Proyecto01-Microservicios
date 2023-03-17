package com.msvc.calificacion.controllers;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion calificacion){
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionService.create(calificacion));
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> listarCalificaciones(){
        return ResponseEntity.status(HttpStatus.OK).body(calificacionService.getCalificaciones());
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorUsuarioId(@PathVariable String usuarioId){
        return ResponseEntity.ok(calificacionService.getCalificacionesByUsuarioId(usuarioId));
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(calificacionService.getCalificacionesByHotelId(hotelId));
    }
    @DeleteMapping("/{calificacionId}")
    public ResponseEntity<String> eliminarCalificacionPorCalificacionId(@PathVariable String calificacionId){
        calificacionService.eleminarCalificacionById(calificacionId);
        return ResponseEntity.ok("Se ha eliminado la calificacion con el ID " + calificacionId);
    }
    @PutMapping("/{calificacionId}")
    public ResponseEntity<?> actualizarCalificacionPorCalificacionId(@PathVariable String calificacionId, @RequestBody Calificacion calificacionRequest) {
        try{
            return ResponseEntity.ok(calificacionService.actualizarCalificacion(calificacionRequest,calificacionId));
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
