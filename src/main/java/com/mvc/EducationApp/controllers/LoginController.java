package com.mvc.EducationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.EducationApp.entities.Estudiante;
import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.entities.Administrador;
import com.mvc.EducationApp.entities.Docente;
import com.mvc.EducationApp.repositories.AdminRepository;
import com.mvc.EducationApp.repositories.DocenteRepository;
import com.mvc.EducationApp.repositories.EstudianteRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/login")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("")
    public Boolean verifyLogin(@RequestBody formLogin formLogin){

        log.info("Verificando el tipo de usuario: " + formLogin.getTipo());

        switch (formLogin.getTipo()) {

            case "1":

                try {

                    Estudiante estudiante = estudianteRepository.findByCorreo(formLogin.getCorreo()).orElseThrow(() -> new IllegalArgumentException ("El estudiante no existe"));

                    if (estudiante.getClave().equals(formLogin.getClave())) {
                        return true;
                    }

                    return false;

                } catch (Exception e) {

                    log.error("Error encontrando al estudiante", e);
                    return false;

                }

            case "2":

                try {

                    Docente docente = docenteRepository.findByCorreo(formLogin.getCorreo()).orElseThrow(() -> new IllegalArgumentException ("El docente no existe"));

                    if (docente.getClave().equals(formLogin.getClave())) {
                        return true;
                    }

                    return false;

                } catch (Exception e) {

                    log.error("Error encontrando al docente", e);
                    return false;

                }

            case "3":

                try {

                    Administrador admin = adminRepository.findByCorreo(formLogin.getCorreo()).orElseThrow(() -> new IllegalArgumentException ("El admin no existe"));

                    if (admin.getClave().equals(formLogin.getClave())) {
                        return true;
                    }

                    return false;

                } catch (Exception e) {

                    log.error("Error encontrando al docente", e);
                    return false;

                }

            default:
                return false;
        }
    }
}