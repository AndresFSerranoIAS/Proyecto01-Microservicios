package com.msvc.calificacion.services;

import com.msvc.calificacion.entities.Calificacion;

import java.util.List;

public interface CalificacionService {

    Calificacion create(Calificacion calificacion);
    List<Calificacion> getCalificaciones();
    List<Calificacion> getCalificacionesByUsuarioId(String usuarioId);
    List<Calificacion> getCalificacionesByHotelId(String hotelId);

    void eleminarCalificacionById(String calificacionId);

    Calificacion actualizarCalificacion(Calificacion calificacion, String calificacionId);


}
