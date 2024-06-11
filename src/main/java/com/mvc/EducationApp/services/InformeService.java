package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.InformeDTO;
import com.mvc.EducationApp.entities.Informe;
import com.mvc.EducationApp.mappers.InformeMapper;
import com.mvc.EducationApp.repositories.InformeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class InformeService {

    @Autowired
    private InformeRepository informeRepository;

    public List<InformeDTO> getAllInformes() {

        try {

            List<Informe> informes = informeRepository.findAll();
            return informes.stream().map(InformeMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los informes", e);

        }

        return List.of();

    }

    public InformeDTO getInformeById(Long id) {

        try {

            Informe informe = informeRepository.findById(id).orElse(null);
            return InformeMapper.INSTANCE.toDTO(informe);

        } catch (Exception e) {

            log.error("Error obteniendo informe por id",e);

        }

        return null;
    }
    
    /*Create, update, delete */
    
    public InformeDTO createInforme(InformeDTO informeDTO){

        try {

            if(informeDTO.getIdInforme() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Informe informe = InformeMapper.INSTANCE.toEntity(informeDTO);
            Informe savedInforme = informeRepository.save(informe);

            return InformeMapper.INSTANCE.toDTO(savedInforme);

        } catch (Exception e) {

            log.error("Error creando informe", e);

        }

        return null;
    }

    public InformeDTO updateInforme(Long id, InformeDTO informeDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Informe informeAActualizar = informeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El informe no existe"));
            Informe informe = InformeMapper.INSTANCE.toEntity(informeDTO);
            
            informe.setIdInforme(informeAActualizar.getIdInforme());

            informeAActualizar = informeRepository.save(informe);

            Informe savedInforme = informeRepository.save(informeAActualizar);
            return InformeMapper.INSTANCE.toDTO(savedInforme);

        } catch (Exception e) {

            log.error("Error actualizando al informe");
            
        }

        return null;
    }

    
    public boolean deleteInforme(Long id) {

        try {

            informeRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el informe");

        }

        return false;
    }
}
