package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.entities.Estudiante;

@Mapper
public interface EstudianteMapper {
    
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(target = "idGrado", source = "idGrado")
    public EstudianteDTO toDTO(Estudiante estudiante);

    public Estudiante toEntity(EstudianteDTO estudianteDTO);
}
