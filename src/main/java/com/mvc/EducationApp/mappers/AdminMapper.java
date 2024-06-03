package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.AdministradorDTO;
import com.mvc.EducationApp.entities.Administrador;

@Mapper
public interface AdminMapper {
    
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    public AdministradorDTO toDTO(Administrador administrador);
    public Administrador toEntity(AdministradorDTO administradorDTO);
}
