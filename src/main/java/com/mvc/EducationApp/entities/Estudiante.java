package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
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
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @ManyToOne
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idUsuario")
    private Long idEstudiante;

    @ManyToOne
    @JoinColumn(name = "grado", referencedColumnName = "idGrado")
    private String grado;

}
