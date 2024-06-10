package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class EstudianteDTO {

    private Long idEstudiante;

    private String nombres;

    private String apellidos;

    private String estado;

    private String correo;

    private Grado idGrado;

}
