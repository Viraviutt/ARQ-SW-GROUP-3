package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "docentes_grados")
@NoArgsConstructor
@AllArgsConstructor
public class DocentesDeGrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocenteGrado;
    
    @ManyToOne
    @JoinColumn(name = "idDocente", referencedColumnName = "idDocente")
    private Docente idDocente;

    @ManyToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private Grado idGrado;
}
