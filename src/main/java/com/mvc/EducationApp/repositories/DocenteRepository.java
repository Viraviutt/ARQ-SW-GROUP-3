package com.mvc.EducationApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Docente;

@RepositoryRestResource
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    @Query("SELECT d FROM Docente d WHERE lower(d.nombres) LIKE lower(?1)")
    Optional<List<Docente>> findByNombre(String nombre);

    @Query("SELECT d FROM Docente d WHERE lower(d.correo) LIKE lower(?1)")
    Optional<Docente> findByCorreo(String correo);

}