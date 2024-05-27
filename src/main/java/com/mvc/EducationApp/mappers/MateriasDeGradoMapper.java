package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.MateriasDeGradoDTO;
import com.mvc.EducationApp.entities.MateriasDeGrado;

@Mapper
public interface MateriasDeGradoMapper {

    MateriasDeGradoMapper INSTANCE = Mappers.getMapper(MateriasDeGradoMapper.class);

    public MateriasDeGradoDTO toDTO(MateriasDeGrado materiasDeGrado);
    public MateriasDeGrado toEntity(MateriasDeGradoDTO materiasDeGradoDTO);
}
