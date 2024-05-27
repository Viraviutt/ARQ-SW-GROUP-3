package com.mvc.EducationApp.entities;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaInforme;

    @OneToOne
    @JoinColumn(name = "idActividad", referencedColumnName = "idActividad")
    private Actividad idActividad;

}
