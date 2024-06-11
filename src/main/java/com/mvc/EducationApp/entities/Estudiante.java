package com.mvc.EducationApp.entities;

import jakarta.persistence.Column;
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String clave;

    @ManyToOne
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private Grado idGrado;

    public void actualizarSoloSi(Estudiante estudianteActualizado) {
        if (estudianteActualizado.getNombres() != null && this.getNombres() != estudianteActualizado.getNombres()) {
            this.setNombres(estudianteActualizado.getNombres());
        }

        if (estudianteActualizado.getApellidos() != null && this.getApellidos() != estudianteActualizado.getApellidos()) {
            this.setApellidos(estudianteActualizado.getApellidos());
        }

        if (estudianteActualizado.getEstado() != null && this.getEstado() != estudianteActualizado.getEstado()) {
            this.setEstado(estudianteActualizado.getEstado());
        }

        if (estudianteActualizado.getCorreo() != null && this.getCorreo() != estudianteActualizado.getCorreo()) {
            this.setCorreo(estudianteActualizado.getCorreo());
        }

        if (estudianteActualizado.getClave() != null && this.getClave() != estudianteActualizado.getClave()) {
            this.setClave(estudianteActualizado.getClave());
        }

        if (estudianteActualizado.getIdGrado() != null && this.getIdGrado() != estudianteActualizado.getIdGrado()) {
            this.setIdGrado(estudianteActualizado.getIdGrado());
        }
    }
}
