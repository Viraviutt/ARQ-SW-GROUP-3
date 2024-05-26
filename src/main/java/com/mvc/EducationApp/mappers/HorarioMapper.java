package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.HorarioDTO;
import com.mvc.EducationApp.entities.Horario;

@Mapper
public interface HorarioMapper {
    HorarioMapper INSTANCE = Mappers.getMapper(HorarioMapper.class);

    public HorarioDTO toDTO(Horario usuario);
    public Horario toEntity(HorarioDTO usuarioDTO);
}
