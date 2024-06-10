package com.mvc.EducationApp.dto;

import lombok.Data;

@Data
public class EstudianteDTO {

    private Long idEstudiante;

    private String nombres;

    private String apellidos;

    private String estado;

    private String correo;

    private String clave;

    private Long idGrado;

}
