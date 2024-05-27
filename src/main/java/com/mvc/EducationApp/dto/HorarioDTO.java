package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;

import lombok.Data;

@Data
public class HorarioDTO {

    private Long idHorario;
    
    private Grado idGrado;
}
