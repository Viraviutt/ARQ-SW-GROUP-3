package com.mvc.EducationApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Administrador;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findByIdAdmin(Long idAdmin);
    
}
