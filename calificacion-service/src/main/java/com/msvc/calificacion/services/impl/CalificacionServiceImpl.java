package com.msvc.calificacion.services.impl;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.repository.CalificacionRepository;
import com.msvc.calificacion.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    @Autowired
    private  CalificacionRepository calificacionRepository;


    @Override
    public Calificacion create(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public List<Calificacion> getCalificacionesByUsuarioId(String usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }

    @Override
    public void eleminarCalificacionById(String calificacionId) {
        calificacionRepository.deleteById(calificacionId);
    }

    @Override
    public Calificacion actualizarCalificacion(Calificacion calificacionRequest, String calificacionId) {
        Optional<Calificacion> existentCalificacion = calificacionRepository.findById(calificacionId);
        if(existentCalificacion.isPresent()){
            Calificacion updatedCalificacion = new Calificacion(existentCalificacion.get().getCalificacionId(),
                    calificacionRequest.getUsuarioId(),
                    calificacionRequest.getHotelId(),
                    calificacionRequest.getCalificacion(),
                    calificacionRequest.getObservaciones());
            return calificacionRepository.save(updatedCalificacion);
        }
        throw new RuntimeException("No se ha encontrado la calificación");

    }
}
