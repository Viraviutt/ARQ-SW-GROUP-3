package com.mvc.EducationApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mvc.EducationApp.entities.Administrador;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Administrador, Long> {
    
}
