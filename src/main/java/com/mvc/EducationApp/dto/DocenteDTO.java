package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Materia;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class DocenteDTO {

    private Long idDocente;

    private String nombres;

    private String apellidos;

    private String estado;

    private String correo;

    private Materia idMateria;
    
}
