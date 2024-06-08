package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.MateriasDeGradoDTO;
import com.mvc.EducationApp.entities.MateriasDeGrado;
import com.mvc.EducationApp.mappers.MateriasDeGradoMapper;
import com.mvc.EducationApp.repositories.MateriasDeGradoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class MateriasDeGradoService {

    @Autowired
    private MateriasDeGradoRepository materiasDeGradoRepository;

    public List<MateriasDeGradoDTO> getAllMateriasDeGrados() {

        try {

            List<MateriasDeGrado> materiasDeGrados = materiasDeGradoRepository.findAll();
            return materiasDeGrados.stream().map(MateriasDeGradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los materiasDeGrados", e);

        }

        return List.of();

    }

    public MateriasDeGradoDTO getMateriasDeGradoById(Long id) {

        try {

            MateriasDeGrado materiasDeGrado = materiasDeGradoRepository.findById(id).orElse(null);
            return MateriasDeGradoMapper.INSTANCE.toDTO(materiasDeGrado);

        } catch (Exception e) {

            log.error("Error obteniendo materiasDeGrado por id",e);

        }

        return null;
    }
/* 
    public List<MateriasDeGradoDTO> getMateriasDeGradoByNombre(String nombre) {

        try {

            List<MateriasDeGrado> materiasDeGrados = materiasDeGradoRepository.findByNombre(nombre).orElse(null);
            return materiasDeGrados.stream().map(MateriasDeGradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e){

            log.error("Error obteniendo materiasDeGrado por nombre", e);

        }

        return List.of();    
    }

    public List<MateriasDeGradoDTO> getMateriasDeGradoByCorreo(String correo) {

        try {

            List<MateriasDeGrado> materiasDeGrados = materiasDeGradoRepository.findByCorreo(correo).orElse(null);
            return materiasDeGrados.stream().map(MateriasDeGradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo materiasDeGrado por email", e);

        }

        return null;
    }

    public List<MateriasDeGradoDTO> getMateriasDeGradoByDireccion(String direccion) {

        try{

            List<MateriasDeGrado> materiasDeGrados = materiasDeGradoRepository.findByDireccion(direccion).orElse(null);
            return materiasDeGrados.stream().map(MateriasDeGradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo materiasDeGrado por direccion");

        }

        return List.of();
    }
*/
    /*Create, update, delete */
    
    public MateriasDeGradoDTO createMateriasDeGrado(MateriasDeGradoDTO materiasDeGradoDTO){

        try {

            if(materiasDeGradoDTO.getIdMateriaGrado() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            MateriasDeGrado materiasDeGrado = MateriasDeGradoMapper.INSTANCE.toEntity(materiasDeGradoDTO);
            MateriasDeGrado savedMateriasDeGrado = materiasDeGradoRepository.save(materiasDeGrado);

            return MateriasDeGradoMapper.INSTANCE.toDTO(savedMateriasDeGrado);

        } catch (Exception e) {

            log.error("Error creando materiasDeGrado", e);

        }

        return null;
    }

    public MateriasDeGradoDTO updateMateriasDeGrado(Long id, MateriasDeGradoDTO materiasDeGradoDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            MateriasDeGrado materiasDeGradoAActualizar = materiasDeGradoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El materiasDeGrado no existe"));
            MateriasDeGrado materiasDeGrado = MateriasDeGradoMapper.INSTANCE.toEntity(materiasDeGradoDTO);
            
            materiasDeGrado.setIdMateriaGrado(materiasDeGradoAActualizar.getIdMateriaGrado());

            materiasDeGradoAActualizar = materiasDeGradoRepository.save(materiasDeGrado);

            MateriasDeGrado savedMateriasDeGrado = materiasDeGradoRepository.save(materiasDeGradoAActualizar);
            return MateriasDeGradoMapper.INSTANCE.toDTO(savedMateriasDeGrado);

        } catch (Exception e) {

            log.error("Error actualizando al materiasDeGrado");
            
        }

        return null;
    }

    
    public boolean deleteMateriasDeGrado(Long id) {

        try {

            materiasDeGradoRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el materiasDeGrado");

        }

        return false;
    }
}
