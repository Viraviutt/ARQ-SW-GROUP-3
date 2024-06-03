package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.TemaDTO;
import com.mvc.EducationApp.entities.Tema;

@Mapper
public interface TemaMapper {
    
    TemaMapper INSTANCE = Mappers.getMapper(TemaMapper.class);

    public TemaDTO toDTO(Tema tema);
    public Tema toEntity(TemaDTO temaDTO);
}
