package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.entities.Materia;

import lombok.Data;

@Data
public class MateriasDeGradoDTO {

    private Long idMateriaGrado;
    
    private Materia idMateria;

    private Grado idGrado;
}
