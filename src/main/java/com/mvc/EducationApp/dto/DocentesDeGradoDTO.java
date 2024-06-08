package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Docente;
import com.mvc.EducationApp.entities.Grado;

import lombok.Data;

@Data
public class DocentesDeGradoDTO {

    private Long idDocenteGrado;
    
    private Docente idDocente;

    private Grado idGrado;
}
