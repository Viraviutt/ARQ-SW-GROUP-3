package com.mvc.EducationApp.entities;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "materias")
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateria;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "docente", referencedColumnName = "idDocente")
    private Docente docente;

    @ManyToMany
    @JoinTable(name = "grados", joinColumns = @JoinColumn(name = "idMateria"), inverseJoinColumns = @JoinColumn(name = "idGrado"))
    @Builder.Default
    private Set<Grado> grados = new HashSet<>();

    public void addGrado(Grado grado) {
        grados.add(grado);
        grado.getMaterias().add(this);
    }

    public void removeGrado(Grado grado) {
        grados.remove(grado);
        grado.getMaterias().remove(this);
    }
}
