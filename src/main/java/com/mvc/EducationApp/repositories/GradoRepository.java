package com.mvc.EducationApp.repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Grado;

@RepositoryRestResource
public interface GradoRepository extends JpaRepository<Grado, Long> {

    /* find by nombre */
    @Query("SELECT g FROM Grado g WHERE g.nombre = ?1")
    Optional<List<Grado>> findByNombre(String nombre);

}
