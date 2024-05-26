package com.mvc.EducationApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Usuario;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /* find by correo */
    @Query("SELECT u FROM Usuario u WHERE lower(u.correo) = lower(?1)")
    Optional<Usuario> findByCorreo(String correo);

}
