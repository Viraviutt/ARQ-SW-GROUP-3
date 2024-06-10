package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.entities.Estudiante;
import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.mappers.EstudianteMapper;
import com.mvc.EducationApp.repositories.EstudianteRepository;
import com.mvc.EducationApp.repositories.GradoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private GradoRepository gradoRepository;

    public List<EstudianteDTO> getAllEstudiantes() {

        try {

            List<Estudiante> estudiantes = estudianteRepository.findAll();
            return estudiantes.stream().map(EstudianteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los estudiantes", e);

        }

        return List.of();

    }

    public EstudianteDTO getEstudianteById(Long id) {

        try {

            Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
            return EstudianteMapper.INSTANCE.toDTO(estudiante);

        } catch (Exception e) {

            log.error("Error obteniendo estudiante por id",e);

        }

        return null;
    }
 
    public List<EstudianteDTO> getEstudianteByNombre(String nombre) {

        try {

            List<Estudiante> estudiantes = estudianteRepository.findByNombre(nombre).orElse(null);
            return estudiantes.stream().map(EstudianteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e){

            log.error("Error obteniendo estudiante por nombre", e);

        }

        return List.of();    
    }
/*
    public List<EstudianteDTO> getEstudianteByCorreo(String correo) {

        try {

            List<Estudiante> estudiantes = estudianteRepository.findByCorreo(correo).orElse(null);
            return estudiantes.stream().map(EstudianteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo estudiante por email", e);

        }

        return null;
    }

    public List<EstudianteDTO> getEstudianteByDireccion(String direccion) {

        try{

            List<Estudiante> estudiantes = estudianteRepository.findByDireccion(direccion).orElse(null);
            return estudiantes.stream().map(EstudianteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo estudiante por direccion");

        }

        return List.of();
    }
*/
    /*Create, update, delete */
    
    public EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO){

        try {

            if(estudianteDTO.getIdEstudiante() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Estudiante estudiante = EstudianteMapper.INSTANCE.toEntity(estudianteDTO);
            Estudiante savedEstudiante = estudianteRepository.save(estudiante);

            return EstudianteMapper.INSTANCE.toDTO(savedEstudiante);

        } catch (Exception e) {

            log.error("Error creando estudiante", e);

        }

        return null;
    }

    public EstudianteDTO updateEstudiante(Long id, EstudianteDTO estudianteDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Grado grado = gradoRepository.findById(estudianteDTO.getIdGrado()).orElseThrow(() -> new IllegalArgumentException("El grado no existe"));

            Estudiante estudianteAActualizar = estudianteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El estudiante no existe"));
            Estudiante estudiante = EstudianteMapper.INSTANCE.toEntity(estudianteDTO);
            
            estudiante.setIdEstudiante(estudianteAActualizar.getIdEstudiante());

            estudiante.setIdGrado(grado);

            estudianteAActualizar = estudianteRepository.save(estudiante);

            Estudiante savedEstudiante = estudianteRepository.save(estudianteAActualizar);
            return EstudianteMapper.INSTANCE.toDTO(savedEstudiante);

        } catch (Exception e) {

            log.error("Error actualizando al estudiante");
            
        }

        return null;
    }

    
    public boolean deleteEstudiante(Long id) {

        try {

            estudianteRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el estudiante");

        }

        return false;
    }
}
