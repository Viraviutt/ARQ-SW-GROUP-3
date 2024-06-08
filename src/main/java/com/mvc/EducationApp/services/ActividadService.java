package com.mvc.EducationApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.ActividadDTO;
import com.mvc.EducationApp.entities.Actividad;
import com.mvc.EducationApp.mappers.ActividadMapper;
import com.mvc.EducationApp.repositories.ActividadRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<ActividadDTO> getAllActividads() {

        try {

            List<Actividad> actividads = actividadRepository.findAll();
            return actividads.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los actividads", e);

        }

        return List.of();

    }

    public ActividadDTO getActividadById(Long id) {

        try {

            Actividad actividad = actividadRepository.findById(id).orElse(null);
            return ActividadMapper.INSTANCE.toDTO(actividad);

        } catch (Exception e) {

            log.error("Error obteniendo actividad por id",e);

        }

        return null;
    }
/*
    public List<ActividadDTO> getActividadByNombre(String nombre) {

        try {

            List<Actividad> actividads = actividadRepository.findByNombre(nombre).orElse(null);
            return actividads.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e){

            log.error("Error obteniendo actividad por nombre", e);

        }

        return List.of();    
    }

    public List<ActividadDTO> getActividadByCorreo(String correo) {

        try {

            List<Actividad> actividads = actividadRepository.findByCorreo(correo).orElse(null);
            return actividads.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo actividad por email", e);

        }

        return null;
    }

    public List<ActividadDTO> getActividadByDireccion(String direccion) {

        try{

            List<Actividad> actividads = actividadRepository.findByDireccion(direccion).orElse(null);
            return actividads.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo actividad por direccion");

        }

        return List.of();
    }
*/
    /*Create, update, delete */
    
    public ActividadDTO createActividad(ActividadDTO actividadDTO){

        try {

            if(actividadDTO.getIdActividad() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Actividad actividad = ActividadMapper.INSTANCE.toEntity(actividadDTO);
            Actividad savedActividad = actividadRepository.save(actividad);

            return ActividadMapper.INSTANCE.toDTO(savedActividad);

        } catch (Exception e) {

            log.error("Error creando actividad", e);

        }

        return null;
    }

    public ActividadDTO updateActividad(Long id, ActividadDTO actividadDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Actividad actividadAActualizar = actividadRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El actividad no existe"));
            Actividad actividad = ActividadMapper.INSTANCE.toEntity(actividadDTO);
            
            actividad.setIdActividad(actividadAActualizar.getIdActividad());

            actividadAActualizar = actividadRepository.save(actividad);

            Actividad savedActividad = actividadRepository.save(actividadAActualizar);
            return ActividadMapper.INSTANCE.toDTO(savedActividad);

        } catch (Exception e) {

            log.error("Error actualizando al actividad");
            
        }

        return null;
    }

    
    public boolean deleteActividad(Long id) {

        try {

            actividadRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el actividad");

        }

        return false;
    }
}
