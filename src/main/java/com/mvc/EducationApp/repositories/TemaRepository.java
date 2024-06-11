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
    @Query("SELECT t FROM Tema t WHERE lower(t.nombre) LIKE lower(?1)")
    Optional<Tema> findByNombre(String email);

    /** find by nombre de materia */
    @Query("SELECT t FROM Tema t JOIN FETCH t.idMateria m JOIN FETCH t.idGrado g WHERE m.idMateria = ?1 AND g.idGrado = ?2")
    Optional<List<Tema>> findByMateriasDeGrado(Long materia, Long grado);

}
