package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "docentes")
@NoArgsConstructor
@AllArgsConstructor
public class Docente {

    @ManyToOne
    @JoinColumn(name = "idDocente", referencedColumnName = "idUsuario")
    private Long idDocente;

    @OneToOne
    @JoinColumn(name = "grado", referencedColumnName = "idGrado")
    private Grado gradoQueLidera;

}
