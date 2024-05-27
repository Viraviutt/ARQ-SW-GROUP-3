package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Rol;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long idUsuario;

    private String nombres;

    private String apellidos;

    private String correo;

    private Rol idRol;

}
