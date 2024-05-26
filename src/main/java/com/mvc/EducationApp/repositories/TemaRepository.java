package com.mvc.EducationApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Tema;

@RepositoryRestResource
public interface TemaRepository extends JpaRepository<Tema, Long> {

    /** find by email */
    @Query("SELECT t FROM Tema t WHERE lower(t.nombre) = lower(?1)")
    Optional<Tema> findByNombre(String email);

    /** find by nombre de materia */
    @Query("SELECT t FROM Tema t JOIN FETCH t.materia m WHERE lower(m.nombre) = lower(?1)")
    Optional<List<Tema>> findByMateria(String materia);

}
