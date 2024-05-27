package com.mvc.EducationApp.dto;


import com.mvc.EducationApp.entities.Docente;

import lombok.Data;

@Data
public class MateriaDTO {

    private Long idMateria;

    private String nombre;

    private Docente idDocente;

}
