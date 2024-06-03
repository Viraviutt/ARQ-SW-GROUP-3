package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.ActividadDTO;
import com.mvc.EducationApp.entities.Actividad;

@Mapper
public interface ActividadMapper {
    
    ActividadMapper INSTANCE = Mappers.getMapper(ActividadMapper.class);

    public ActividadDTO toDTO(Actividad actividad);
    public Actividad toEntity(ActividadDTO actividadDTO);
}
