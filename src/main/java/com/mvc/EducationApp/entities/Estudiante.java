package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "estudiantes")
public class Estudiante extends Usuario {

    @ManyToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private Grado idGrado;

    public Estudiante() {
        super();
    }

    public Estudiante(Grado idGrado) {
        super();
        this.idGrado = idGrado;
    }

}
