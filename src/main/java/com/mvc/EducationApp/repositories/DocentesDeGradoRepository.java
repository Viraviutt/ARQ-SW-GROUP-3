package com.mvc.EducationApp.repositories;

import java.util.Optional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.DocentesDeGrado;

@RepositoryRestResource
public interface DocentesDeGradoRepository extends JpaRepository<DocentesDeGrado, Long> {

    @Query("SELECT d FROM DocentesDeGrado d WHERE d.idDocente.idDocente = ?1")
    Optional<List<DocentesDeGrado>> findByIdDocente(Long idDocente);

}
