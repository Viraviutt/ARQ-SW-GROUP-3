package com.mvc.EducationApp.dto;

import java.sql.Time;

import com.mvc.EducationApp.entities.Grado;
import com.mvc.EducationApp.entities.Materia;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
