package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.DocenteDTO;
import com.mvc.EducationApp.entities.Docente;

@Mapper
public interface DocenteMapper {
    
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);

    public DocenteDTO toDTO(Docente docente);
    
    @Mapping(target = "clave", ignore = true)
    public Docente toEntity(DocenteDTO docenteDTO);
}
