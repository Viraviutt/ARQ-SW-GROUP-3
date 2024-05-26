package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Docente;

import lombok.Data;

@Data
public class GradoDTO {

    private Long idGrado;

    private String nombre;

    private String codigo;

    private Docente docente;
}
