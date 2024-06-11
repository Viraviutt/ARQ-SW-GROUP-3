package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.MateriaDTO;
import com.mvc.EducationApp.entities.Materia;
import com.mvc.EducationApp.mappers.MateriaMapper;
import com.mvc.EducationApp.repositories.MateriaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<MateriaDTO> getAllMaterias() {

        try {

            List<Materia> materias = materiaRepository.findAll();
            return materias.stream().map(MateriaMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los materias", e);

        }

        return List.of();

    }

    public MateriaDTO getMateriaById(Long id) {

        try {

            Materia materia = materiaRepository.findById(id).orElse(null);
            return MateriaMapper.INSTANCE.toDTO(materia);

        } catch (Exception e) {

            log.error("Error obteniendo materia por id",e);

        }

        return null;
    }
    
    /*Create, update, delete */
    
    public MateriaDTO createMateria(MateriaDTO materiaDTO){

        try {

            if(materiaDTO.getIdMateria() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Materia materia = MateriaMapper.INSTANCE.toEntity(materiaDTO);
            Materia savedMateria = materiaRepository.save(materia);

            return MateriaMapper.INSTANCE.toDTO(savedMateria);

        } catch (Exception e) {

            log.error("Error creando materia", e);

        }

        return null;
    }

    public MateriaDTO updateMateria(Long id, MateriaDTO materiaDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Materia materiaAActualizar = materiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El materia no existe"));
            Materia materia = MateriaMapper.INSTANCE.toEntity(materiaDTO);
            
            materia.setIdMateria(materiaAActualizar.getIdMateria());

            materiaAActualizar = materiaRepository.save(materia);

            Materia savedMateria = materiaRepository.save(materiaAActualizar);
            return MateriaMapper.INSTANCE.toDTO(savedMateria);

        } catch (Exception e) {

            log.error("Error actualizando al materia");
            
        }

        return null;
    }

    
    public boolean deleteMateria(Long id) {

        try {

            materiaRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el materia");

        }

        return false;
    }
}
