package com.mvc.EducationApp.repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Informe;

@RepositoryRestResource
public interface InformeRepository extends JpaRepository<Informe, Long> {

    @Query("SELECT i FROM Informe i WHERE i.fechaInforme >= ?1 AND i.fechaInforme <= ?2")
    Optional<List<Informe>> findByFechaBetween(Timestamp fecha1, Timestamp fecha2);

    @Query("SELECT i FROM Informe i JOIN FETCH i.idActividad a JOIN FETCH a.idMateria m WHERE i.fechaInforme = ?1 AND lower(m.nombre) LIKE lower(?2)")
    Optional<List<Informe>> findByFechaAndMateria(Timestamp fecha, String materia);

}
