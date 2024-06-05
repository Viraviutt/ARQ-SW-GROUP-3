package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.AdministradorDTO;
import com.mvc.EducationApp.entities.Administrador;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdminMapper extends UsuarioMapper{
    
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mapping(target = "idUsuario", source = "idUsuario")
    public AdministradorDTO toDTO(Administrador administrador);

    @Mapping(target = "idUsuario", source = "idUsuario")
    public Administrador toEntity(AdministradorDTO administradorDTO);
}
