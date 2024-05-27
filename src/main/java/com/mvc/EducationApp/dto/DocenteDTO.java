package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;

import lombok.Data;

@Data
public class DocenteDTO {

    private Long idDocente;

    private Grado idGrado;
}
