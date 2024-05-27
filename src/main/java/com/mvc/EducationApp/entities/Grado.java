package com.mvc.EducationApp.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "grados")
@NoArgsConstructor
@AllArgsConstructor
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrado;

    @Column(nullable = false)    
    private String nombre;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private Docente docente;

    @ManyToMany(mappedBy = "grados")
    private Set<Materia> materias;

}
