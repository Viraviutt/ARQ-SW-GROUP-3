package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Docente;
import com.mvc.EducationApp.entities.Grado;

import lombok.Data;

@Data
public class MateriaDTO {

    private Long idMateria;

    private Docente docente;

    private Grado grado;

}
