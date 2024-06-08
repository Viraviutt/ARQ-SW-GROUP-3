package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.GradoDTO;
import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.mappers.GradoMapper;
import com.mvc.EducationApp.repositories.GradoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class GradoService {

    @Autowired
    private GradoRepository gradoRepository;

    public List<GradoDTO> getAllGrados() {

        try {

            List<Grado> grados = gradoRepository.findAll();
            return grados.stream().map(GradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los grados", e);

        }

        return List.of();

    }

    public GradoDTO getGradoById(Long id) {

        try {

            Grado grado = gradoRepository.findById(id).orElse(null);
            return GradoMapper.INSTANCE.toDTO(grado);

        } catch (Exception e) {

            log.error("Error obteniendo grado por id", e);

        }

        return null;
    }

    public List<GradoDTO> getGradoByNombre(String nombre) {

        try {

            List<Grado> grados = gradoRepository.findByNombre(nombre).orElse(null);
            return grados.stream().map(GradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo grado por nombre", e);

        }

        return List.of();
    }
/* 
    public List<GradoDTO> getGradoByCorreo(String correo) {

        try {

            List<Grado> grados = gradoRepository.findByCorreo(correo).orElse(null);
            return grados.stream().map(GradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo grado por email", e);

        }

        return null;
    }

    public List<GradoDTO> getGradoByDireccion(String direccion) {

        try {

            List<Grado> grados = gradoRepository.findByDireccion(direccion).orElse(null);
            return grados.stream().map(GradoMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo grado por direccion");

        }

        return List.of();
    }
*/
    /* Create, update, delete */

    public GradoDTO createGrado(GradoDTO gradoDTO) {

        try {

            if (gradoDTO.getIdGrado() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Grado grado = GradoMapper.INSTANCE.toEntity(gradoDTO);
            Grado savedGrado = gradoRepository.save(grado);

            return GradoMapper.INSTANCE.toDTO(savedGrado);

        } catch (Exception e) {

            log.error("Error creando grado", e);

        }

        return null;
    }

    public GradoDTO updateGrado(Long id, GradoDTO gradoDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Grado gradoAActualizar = gradoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("El grado no existe"));
            Grado grado = GradoMapper.INSTANCE.toEntity(gradoDTO);

            grado.setIdGrado(gradoAActualizar.getIdGrado());

            gradoAActualizar = gradoRepository.save(grado);

            Grado savedGrado = gradoRepository.save(gradoAActualizar);
            return GradoMapper.INSTANCE.toDTO(savedGrado);

        } catch (Exception e) {

            log.error("Error actualizando el grado");

        }

        return null;
    }

    public boolean deleteGrado(Long id) {

        try {

            gradoRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el grado");

        }

        return false;
    }

}
