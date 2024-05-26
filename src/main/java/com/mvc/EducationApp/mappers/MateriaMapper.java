package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.MateriaDTO;
import com.mvc.EducationApp.entities.Materia;

@Mapper
public interface MateriaMapper {
    MateriaMapper INSTANCE = Mappers.getMapper(MateriaMapper.class);

    public MateriaDTO toDTO(Materia materia);
    public Materia toEntity(MateriaDTO materiaDTO);
}
