package com.mvc.EducationApp.dto;

import java.sql.Time;

import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.entities.Materia;

import lombok.Data;

@Data
public class HorarioDTO {


    private Long idHorario;

    private Time horaInicio;
    
    private Time horaFin;

    private String dia;

    private Materia idMateria;
    
    private Grado idGrado;
}
