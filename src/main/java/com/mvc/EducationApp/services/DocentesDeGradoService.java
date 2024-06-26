package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.DocentesDeGradoDTO;
import com.mvc.EducationApp.entities.Docente;
import com.mvc.EducationApp.entities.DocentesDeGrado;
import com.mvc.EducationApp.mappers.DocentesDeGradoMapper;
import com.mvc.EducationApp.repositories.DocenteRepository;
import com.mvc.EducationApp.repositories.DocentesDeGradoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class DocentesDeGradoService {

    @Autowired
    private DocentesDeGradoRepository docentesDeGradoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    public List<DocentesDeGradoDTO> getAllDocentesDeGrados() {

        try {

            List<DocentesDeGrado> docentesDeGrados = docentesDeGradoRepository.findAll();
            return docentesDeGrados.stream().map(DocentesDeGradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los docentesDeGrados", e);

        }

        return List.of();

    }

    public List<DocentesDeGradoDTO> getDocentesDeGradoByIdDocente(Long id) {

        try {

            Docente docente = docenteRepository.findById(id).orElse(null);

            List<DocentesDeGrado> docentesDeGrados = docentesDeGradoRepository.findByIdDocente(docente.getIdDocente()).orElse(null);

            return docentesDeGrados.stream().map(DocentesDeGradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo docentesDeGrado por id",e);

        }

        return List.of();
    }
    
    /*Create, update, delete */
    
    public DocentesDeGradoDTO createDocentesDeGrado(DocentesDeGradoDTO docentesDeGradoDTO){

        try {

            if(docentesDeGradoDTO.getIdDocenteGrado() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            DocentesDeGrado docentesDeGrado = DocentesDeGradoMapper.INSTANCE.toEntity(docentesDeGradoDTO);
            DocentesDeGrado savedDocentesDeGrado = docentesDeGradoRepository.save(docentesDeGrado);

            return DocentesDeGradoMapper.INSTANCE.toDTO(savedDocentesDeGrado);

        } catch (Exception e) {

            log.error("Error creando docentesDeGrado", e);

        }

        return null;
    }

    public DocentesDeGradoDTO updateDocentesDeGrado(Long id, DocentesDeGradoDTO docentesDeGradoDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            DocentesDeGrado docentesDeGradoAActualizar = docentesDeGradoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El docentesDeGrado no existe"));
            DocentesDeGrado docentesDeGrado = DocentesDeGradoMapper.INSTANCE.toEntity(docentesDeGradoDTO);
            
            docentesDeGrado.setIdDocenteGrado(docentesDeGradoAActualizar.getIdDocenteGrado());

            docentesDeGradoAActualizar = docentesDeGradoRepository.save(docentesDeGrado);

            DocentesDeGrado savedDocentesDeGrado = docentesDeGradoRepository.save(docentesDeGradoAActualizar);
            return DocentesDeGradoMapper.INSTANCE.toDTO(savedDocentesDeGrado);

        } catch (Exception e) {

            log.error("Error actualizando al docentesDeGrado");
            
        }

        return null;
    }

    
    public boolean deleteDocentesDeGrado(Long id) {

        try {

            docentesDeGradoRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el docentesDeGrado");

        }

        return false;
    }
}
