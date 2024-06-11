package com.mvc.EducationApp.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Estudiante;

@RepositoryRestResource
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT e FROM Estudiante e WHERE lower(e.nombres) LIKE lower(?1)")
    Optional<List<Estudiante>> findByNombre(String nombre);

    @Query("SELECT e FROM Estudiante e WHERE lower(e.correo) LIKE lower(?1)")
    Optional<Estudiante> findByCorreo(String correo);

    @Query("SELECT e FROM Estudiante e JOIN FETCH e.idGrado g WHERE g.idGrado = ?1")
    Optional<List<Estudiante>> findByGradoId(Long id);

}
