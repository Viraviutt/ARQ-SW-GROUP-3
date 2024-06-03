package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;

import lombok.Data;

@Data
public class EstudianteDTO {

    private Long idEstudiante;

    private Grado idGrado;
}
