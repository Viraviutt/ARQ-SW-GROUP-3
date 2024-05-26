package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Materia;

import lombok.Data;

@Data
public class ActividadDTO {

    private Long idActividad;

    private String titulo;

    private String descripcion;
 
    private String nota;
  
    private Materia materia;
}
