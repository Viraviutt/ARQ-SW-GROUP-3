package com.mvc.EducationApp.entities;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "informes")
@NoArgsConstructor
@AllArgsConstructor

public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInforme;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    private Timestamp fechaInforme;

    @Column(nullable = false)
    private Actividad actividad;

}
