package com.mvc.EducationApp.entities;

import java.sql.Time;

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
@Table(name = "horarios")
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Time horaInicio;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Time horaFin;

    @Column(nullable = false)
    private String dia;

    @OneToOne
    @JoinColumn(name = "idMateria", referencedColumnName = "idMateria")
    private Materia idMateria;
    
    @OneToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private Grado idGrado;

}
