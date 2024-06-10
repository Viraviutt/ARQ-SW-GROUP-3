package com.mvc.EducationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.EducationApp.entities.Estudiante;
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

    @GetMapping("")
    public Boolean verifyLogin(
            @RequestParam("correo") String correo,
            @RequestParam("tipo") String tipo
    ){

        log.info("Verificando el tipo de usuario: " + tipo);

        switch (tipo) {

            case "1":

                try {

                    Estudiante estudiante = estudianteRepository.findByCorreo(correo).orElseThrow(() -> new IllegalArgumentException ("El estudiante no existe"));

                    if (estudiante == null) {
                        return false;
                    }

                    return true;

                } catch (Exception e) {

                    log.error("Error encontrando al estudiante", e);
                    return false;

                }

            case "2":

                try {

                    Docente docente = docenteRepository.findByCorreo(correo).orElseThrow(() -> new IllegalArgumentException ("El docente no existe"));

                    if (docente == null) {
                        return false;
                    }

                    return true;

                } catch (Exception e) {

                    log.error("Error encontrando al docente", e);
                    return false;

                }

            case "3":

                try {

                    Administrador admin = adminRepository.findByCorreo(correo).orElseThrow(() -> new IllegalArgumentException ("El admin no existe"));

                    if (admin == null) {
                        return false;
                    }

                    return true;

                } catch (Exception e) {

                    log.error("Error encontrando al docente", e);
                    return false;

                }

            default:
                return false;
        }
    }
}