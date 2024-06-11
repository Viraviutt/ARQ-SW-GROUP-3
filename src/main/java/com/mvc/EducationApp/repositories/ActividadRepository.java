package com.mvc.EducationApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Actividad;
import com.mvc.EducationApp.entities.Tema;


@RepositoryRestResource
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    /* find by nombre de una materia */
    @Query("SELECT a FROM Actividad a JOIN FETCH a.idMateria m WHERE lower(m.nombre) LIKE lower(?1)")
    Optional<List<Actividad>> findByMateria(String materia);

    @Query("SELECT a FROM Actividad a WHERE a.idGrado.idGrado = ?1")
    Optional<List<Actividad>> findByGrado(Long grado);

    @Query("SELECT a FROM Actividad a WHERE a.idMateria.idMateria = ?1 AND a.idGrado.idGrado = ?2")
    Optional<List<Actividad>> findByMateriasAndGradoId(Long materia, Long grado);

    @Query("SELECT a.idMateria.nombre, AVG(CAST(a.nota AS INTEGER)) AS promedio_notas FROM Actividad a WHERE a.idGrado = ?1 GROUP BY a.idMateria.nombre")
    Optional<List<Actividad>> promedioNotas(Long grado);

 }