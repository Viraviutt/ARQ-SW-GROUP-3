package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.UsuarioDTO;
import com.mvc.EducationApp.entities.Usuario;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    public UsuarioDTO toDTO(Usuario usuario);

    @Mapping(target = "clave", ignore = true)
    public Usuario toEntity(UsuarioDTO usuarioDTO);

}
