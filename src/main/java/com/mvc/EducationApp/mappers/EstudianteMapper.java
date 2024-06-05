package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.entities.Estudiante;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EstudianteMapper extends UsuarioMapper {
    
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(target = "idUsuario", source = "idUsuario")
    public EstudianteDTO toDTO(Estudiante usuario);

    @Mapping(target = "idUsuario", source = "idUsuario")
    public Estudiante toEntity(EstudianteDTO usuarioDTO);
}
