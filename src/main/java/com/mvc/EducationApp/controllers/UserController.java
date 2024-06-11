package com.mvc.EducationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.EducationApp.entities.Estudiante;
import com.mvc.EducationApp.dto.CountUsers;
import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.dto.FormLogin;
import com.mvc.EducationApp.entities.Administrador;
import com.mvc.EducationApp.entities.Docente;
import com.mvc.EducationApp.repositories.AdminRepository;
import com.mvc.EducationApp.repositories.DocenteRepository;
import com.mvc.EducationApp.repositories.EstudianteRepository;
import com.mvc.EducationApp.services.AdminService;
import com.mvc.EducationApp.services.DocenteService;
import com.mvc.EducationApp.services.EstudianteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/countUsers")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    DocenteService docenteService;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    AdminService adminService;

    CountUsers countUsers;

    @GetMapping("")
    public CountUsers countUsers() {

        countUsers.setCountEstudiantes(estudianteService.getCounterEstudiante());
        countUsers.setCountDocentes(docenteService.getCounterDocente());
        countUsers.setCountAdmins(adminService.getCounterAdmin());

        return countUsers;
    }

}
