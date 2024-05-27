package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    @ManyToOne
    @JoinColumn(name = "idDocente", referencedColumnName = "idDocente")
    private Long idDocente;

    @OneToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private Grado idGrado;

}
