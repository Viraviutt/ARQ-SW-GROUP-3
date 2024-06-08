package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.DocentesDeGradoDTO;
import com.mvc.EducationApp.entities.DocentesDeGrado;

@Mapper
public interface DocentesDeGradoMapper {

    DocentesDeGradoMapper INSTANCE = Mappers.getMapper(DocentesDeGradoMapper.class);

    public DocentesDeGradoDTO toDTO(DocentesDeGrado docentesDeGrado);
    public DocentesDeGrado toEntity(DocentesDeGradoDTO docentesDeGradoDTO);
}
