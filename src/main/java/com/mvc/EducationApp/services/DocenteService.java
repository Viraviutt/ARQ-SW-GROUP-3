package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.DocenteDTO;
import com.mvc.EducationApp.entities.Docente;
import com.mvc.EducationApp.mappers.DocenteMapper;
import com.mvc.EducationApp.repositories.DocenteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<DocenteDTO> getAllDocentes() {

        try {

            List<Docente> docentes = docenteRepository.findAll();
            return docentes.stream().map(DocenteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los docentes", e);

        }

        return List.of();

    }

    public DocenteDTO getDocenteById(Long id) {

        try {

            Docente docente = docenteRepository.findById(id).orElse(null);
            return DocenteMapper.INSTANCE.toDTO(docente);

        } catch (Exception e) {

            log.error("Error obteniendo docente por id",e);

        }

        return null;
    }
 
    public List<DocenteDTO> getDocenteByNombre(String nombre) {

        try {

            List<Docente> docentes = docenteRepository.findByNombre(nombre).orElse(null);
            return docentes.stream().map(DocenteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e){

            log.error("Error obteniendo docente por nombre", e);

        }

        return List.of();
    }

/*
    public List<DocenteDTO> getDocenteByCorreo(String correo) {

        try {

            List<Docente> docentes = docenteRepository.findByCorreo(correo).orElse(null);
            return docentes.stream().map(DocenteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo docente por email", e);

        }

        return null;
    }

    public List<DocenteDTO> getDocenteByDireccion(String direccion) {

        try{

            List<Docente> docentes = docenteRepository.findByDireccion(direccion).orElse(null);
            return docentes.stream().map(DocenteMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo docente por direccion");

        }

        return List.of();
    }
*/
    /*Create, update, delete */
    
    public DocenteDTO createDocente(DocenteDTO docenteDTO){

        try {

            if(docenteDTO.getIdDocente() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Docente docente = DocenteMapper.INSTANCE.toEntity(docenteDTO);
            Docente savedDocente = docenteRepository.save(docente);

            return DocenteMapper.INSTANCE.toDTO(savedDocente);

        } catch (Exception e) {

            log.error("Error creando docente", e);

        }

        return null;
    }

    public DocenteDTO updateDocente(Long id, DocenteDTO docenteDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Docente docenteAActualizar = docenteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El docente no existe"));
            Docente docente = DocenteMapper.INSTANCE.toEntity(docenteDTO);
            
            docente.setIdDocente(docenteAActualizar.getIdDocente());

            docenteAActualizar = docenteRepository.save(docente);

            Docente savedDocente = docenteRepository.save(docenteAActualizar);
            return DocenteMapper.INSTANCE.toDTO(savedDocente);

        } catch (Exception e) {

            log.error("Error actualizando al docente");
            
        }

        return null;
    }

    
    public boolean deleteDocente(Long id) {

        try {

            docenteRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el docente");

        }

        return false;
    }
}
