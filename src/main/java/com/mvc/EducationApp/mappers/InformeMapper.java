package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.InformeDTO;
import com.mvc.EducationApp.entities.Informe;

@Mapper
public interface InformeMapper {
    
    InformeMapper INSTANCE = Mappers.getMapper(InformeMapper.class);

    public InformeDTO toDTO(Informe usuario);
    public Informe toEntity(InformeDTO usuarioDTO);
}
