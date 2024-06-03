package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
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
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    
    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idUsuario", unique = true)
    @Id
    private Long idEstudiante;

    @ManyToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private Grado idGrado;

}
