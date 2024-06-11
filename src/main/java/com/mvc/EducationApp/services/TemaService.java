package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.TemaDTO;
import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.entities.MateriasDeGrado;
import com.mvc.EducationApp.entities.Tema;
import com.mvc.EducationApp.mappers.TemaMapper;
import com.mvc.EducationApp.repositories.GradoRepository;
import com.mvc.EducationApp.repositories.MateriasDeGradoRepository;
import com.mvc.EducationApp.repositories.TemaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private MateriasDeGradoRepository materiasDeGradoRepository;

    @Autowired
    private GradoRepository gradoRepository;

    public List<TemaDTO> getAllTemas() {

        try {

            List<Tema> temas = temaRepository.findAll();
            return temas.stream().map(TemaMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los temas", e);

        }

        return List.of();

    }

    public TemaDTO getTemaById(Long id) {

        try {

            Tema tema = temaRepository.findById(id).orElse(null);
            return TemaMapper.INSTANCE.toDTO(tema);

        } catch (Exception e) {

            log.error("Error obteniendo tema por id",e);

        }

        return null;
    }
 
    public List<TemaDTO> getTemaByMateriasDeGrado(Long materia, Long grado) {

        try {

            MateriasDeGrado materiasDeGrado = materiasDeGradoRepository.findById(materia).orElse(null);

            Grado grados = gradoRepository.findById(grado).orElse(null);

            List<Tema> temas = temaRepository.findByMateriasDeGrado(materiasDeGrado.getIdMateria().getIdMateria(), grados.getIdGrado()).orElse(null);
            return temas.stream().map(TemaMapper.INSTANCE::toDTO).toList();

        } catch (Exception e){

            log.error("Error obteniendo tema por nombre", e);

        }

        return List.of();    
    }
/*
    public List<TemaDTO> getTemaByCorreo(String correo) {

        try {

            List<Tema> temas = temaRepository.findByCorreo(correo).orElse(null);
            return temas.stream().map(TemaMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo tema por email", e);

        }

        return null;
    }

    public List<TemaDTO> getTemaByDireccion(String direccion) {

        try{

            List<Tema> temas = temaRepository.findByDireccion(direccion).orElse(null);
            return temas.stream().map(TemaMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo tema por direccion");

        }

        return List.of();
    }
*/
    /*Create, update, delete */
    
    public TemaDTO createTema(TemaDTO temaDTO){

        try {

            if(temaDTO.getIdTema() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Tema tema = TemaMapper.INSTANCE.toEntity(temaDTO);
            Tema savedTema = temaRepository.save(tema);

            return TemaMapper.INSTANCE.toDTO(savedTema);

        } catch (Exception e) {

            log.error("Error creando tema", e);

        }

        return null;
    }

    public TemaDTO updateTema(Long id, TemaDTO temaDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Tema temaAActualizar = temaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El tema no existe"));
            Tema tema = TemaMapper.INSTANCE.toEntity(temaDTO);
            
            tema.setIdTema(temaAActualizar.getIdTema());

            temaAActualizar = temaRepository.save(tema);

            Tema savedTema = temaRepository.save(temaAActualizar);
            return TemaMapper.INSTANCE.toDTO(savedTema);

        } catch (Exception e) {

            log.error("Error actualizando al tema");
            
        }

        return null;
    }

    
    public boolean deleteTema(Long id) {

        try {

            temaRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el tema");

        }

        return false;
    }
}
