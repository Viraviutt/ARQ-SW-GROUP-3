package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.RolDTO;
import com.mvc.EducationApp.entities.Rol;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    public RolDTO toDTO(Rol rol);
    public Rol toEntity(RolDTO rolDTO);

}
