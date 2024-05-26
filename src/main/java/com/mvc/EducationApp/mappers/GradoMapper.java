package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.GradoDTO;
import com.mvc.EducationApp.entities.Grado;

@Mapper
public interface GradoMapper {
    GradoMapper INSTANCE = Mappers.getMapper(GradoMapper.class);

    public GradoDTO toDTO(Grado usuario);
    public Grado toEntity(GradoDTO usuarioDTO);
}
