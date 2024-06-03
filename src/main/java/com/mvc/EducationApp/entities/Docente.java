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
@Table(name = "docentes")
@NoArgsConstructor
@AllArgsConstructor
public class Docente {

    @Id
    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "idDocente", referencedColumnName = "idUsuario", unique = true)
    private Long idDocente;

}
