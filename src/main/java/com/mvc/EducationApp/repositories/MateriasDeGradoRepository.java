package com.mvc.EducationApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.MateriasDeGrado;

@RepositoryRestResource
public interface MateriasDeGradoRepository extends JpaRepository<MateriasDeGrado, Long> {

    @Query("SELECT mg FROM MateriasDeGrado mg JOIN FETCH e.idGrado g JOIN FETCH g.idMateria m WHERE g.idGrado = ?1 ")
    Optional<List<MateriasDeGrado>> findByGradoIdMateria(Long id);

}
