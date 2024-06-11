package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.HorarioDTO;
import com.mvc.EducationApp.entities.Horario;
import com.mvc.EducationApp.mappers.HorarioMapper;
import com.mvc.EducationApp.repositories.HorarioRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<HorarioDTO> getAllHorarios() {

        try {

            List<Horario> horarios = horarioRepository.findAll();
            return horarios.stream().map(HorarioMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los horarios", e);

        }

        return List.of();

    }

    public HorarioDTO getHorarioById(Long id) {

        try {

            Horario horario = horarioRepository.findById(id).orElse(null);
            return HorarioMapper.INSTANCE.toDTO(horario);

        } catch (Exception e) {

            log.error("Error obteniendo horario por id",e);

        }

        return null;
    }
    
    /*Create, update, delete */
    
    public HorarioDTO createHorario(HorarioDTO horarioDTO){

        try {

            if(horarioDTO.getIdHorario() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Horario horario = HorarioMapper.INSTANCE.toEntity(horarioDTO);
            Horario savedHorario = horarioRepository.save(horario);

            return HorarioMapper.INSTANCE.toDTO(savedHorario);

        } catch (Exception e) {

            log.error("Error creando horario", e);

        }

        return null;
    }

    public HorarioDTO updateHorario(Long id, HorarioDTO horarioDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Horario horarioAActualizar = horarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El horario no existe"));
            Horario horario = HorarioMapper.INSTANCE.toEntity(horarioDTO);
            
            horario.setIdHorario(horarioAActualizar.getIdHorario());

            horarioAActualizar = horarioRepository.save(horario);

            Horario savedHorario = horarioRepository.save(horarioAActualizar);
            return HorarioMapper.INSTANCE.toDTO(savedHorario);

        } catch (Exception e) {

            log.error("Error actualizando al horario");
            
        }

        return null;
    }

    
    public boolean deleteHorario(Long id) {

        try {

            horarioRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el horario");

        }

        return false;
    }
}
