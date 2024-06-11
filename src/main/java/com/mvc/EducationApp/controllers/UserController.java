package com.mvc.EducationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.EducationApp.dto.CountUsers;
import com.mvc.EducationApp.services.AdminService;
import com.mvc.EducationApp.services.DocenteService;
import com.mvc.EducationApp.services.EstudianteService;


@RestController
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

    @GetMapping("")
    public CountUsers countUsers() {

        return new CountUsers(estudianteService.getCounterEstudiante(), docenteService.getCounterDocente(), adminService.getCounterAdmin());
        
    }

}
