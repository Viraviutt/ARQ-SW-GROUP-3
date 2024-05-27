package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.UsuarioDTO;
import com.mvc.EducationApp.entities.Usuario;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    public UsuarioDTO toDTO(Usuario usuario);
    public Usuario toEntity(UsuarioDTO usuarioDTO);

}