package com.mvc.EducationApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Horario;

@RepositoryRestResource
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    /* find by grado */
    @Query("SELECT h FROM Horario h WHERE h.grado.nombre = ?1 AND h.grado.codigo = ?2")
    Optional<Horario> findByGrado(String nombre, String codigo);

}
