package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.entities.Estudiante;

@Mapper
public interface EstudianteMapper {
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    public EstudianteDTO toDTO(Estudiante usuario);
    public Estudiante toEntity(EstudianteDTO usuarioDTO);
}
