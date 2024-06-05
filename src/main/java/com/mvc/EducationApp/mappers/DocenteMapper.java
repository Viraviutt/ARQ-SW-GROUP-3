package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.DocenteDTO;
import com.mvc.EducationApp.entities.Docente;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocenteMapper extends UsuarioMapper{
    
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);

    @Mapping(target = "idUsuario", source = "idUsuario")
    public DocenteDTO toDTO(Docente docente);

    @Mapping(target = "idUsuario", source = "idUsuario")
    public Docente toEntity(DocenteDTO docenteDTO);
}
