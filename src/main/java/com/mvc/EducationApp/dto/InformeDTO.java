package com.mvc.EducationApp.dto;

import java.sql.Timestamp;

import com.mvc.EducationApp.entities.Actividad;

import lombok.Data;

@Data
public class InformeDTO {

    private Long idInforme;

    private String asunto;

    private String contenido;

    private Timestamp fechaInforme;

    private Actividad actividad;
}
