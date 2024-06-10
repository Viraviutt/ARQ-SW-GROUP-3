package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Materia;

import lombok.Data;

@Data
public class DocenteDTO {

    private Long idDocente;

    private String nombres;

    private String apellidos;

    private String estado;

    private String correo;

    private String clave;

    private Materia idMateria;
    
}
