package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.entities.Materia;

import lombok.Data;

@Data
public class TemaDTO {
 
    private Long idTema;

    private String nombre;

    private String descripcion;

    private Materia idMateria;

    private Grado idGrado;
}
