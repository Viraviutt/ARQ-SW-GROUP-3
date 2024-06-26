package com.mvc.EducationApp.services;

import java.util.HashMap;
import java.util.List;

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

    public List<ActividadDTO> getAllActividades() {

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

            log.error("Error obteniendo actividad por id", e);

        }

        return null;
    }

    public List<ActividadDTO> getActividadByMateria(String materia) {

        try {

            List<Actividad> actividades = actividadRepository.findByMateria(materia).orElse(null);
            return actividades.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo actividad por nombre", e);

        }

        return List.of();
    }

    public List<ActividadDTO> getActividadByGrado(Long grado) {

        try {

            List<Actividad> actividades = actividadRepository.findByGrado(grado).orElse(null);
            return actividades.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo actividad por nombre", e);

        }

        return List.of();
    }

    public HashMap<String, Float> getPromedioNotas(Long grado) {

        try {

            HashMap<String, Float> agrupacionPromedio = new HashMap<>();

            List<Actividad> actividades = actividadRepository.findByGrado(grado).orElse(null);

            HashMap<String, Integer> agrupacionCounter = new HashMap<>();

            for (Actividad actividad : actividades) {
                if (agrupacionPromedio.containsKey(actividad.getIdMateria().getNombre())) {

                    agrupacionPromedio.put(actividad.getIdMateria().getNombre(), agrupacionPromedio.get(actividad.getIdMateria().getNombre()) + Float.parseFloat(actividad.getNota()));
                    agrupacionCounter.put(actividad.getIdMateria().getNombre(), agrupacionCounter.get(actividad.getIdMateria().getNombre()) + 1);

                }else{

                    agrupacionCounter.put(actividad.getIdMateria().getNombre(), 0);
                    agrupacionPromedio.put(actividad.getIdMateria().getNombre(), 0F);
                    agrupacionPromedio.put(actividad.getIdMateria().getNombre(), agrupacionPromedio.get(actividad.getIdMateria().getNombre()) + Float.parseFloat(actividad.getNota()));
                    agrupacionCounter.put(actividad.getIdMateria().getNombre(), agrupacionCounter.get(actividad.getIdMateria().getNombre()) + 1);

                }
            }

            HashMap<String, Float> promedio = new HashMap<>();

            for (String key : agrupacionPromedio.keySet()) {

                promedio.put(key, agrupacionPromedio.get(key) / agrupacionCounter.get(key));
                
            }

            
            return promedio;

        } catch (Exception e) {

            log.error("Error obteniendo promedio de notas.", e);

        }

        return null;
    }

    public List<ActividadDTO> getActividadByMateriasAndGradoId(Long materia, Long grado) {

        try {

            List<Actividad> actividades = actividadRepository.findByMateriasAndGradoId(materia, grado).orElse(null);
            return actividades.stream().map(ActividadMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo tema por nombre", e);

        }

        return List.of();
    }
    
    /* Create, update, delete */

    public ActividadDTO createActividad(ActividadDTO actividadDTO) {

        try {

            if (actividadDTO.getIdActividad() != null) {
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

            Actividad actividadAActualizar = actividadRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("El actividad no existe"));
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
