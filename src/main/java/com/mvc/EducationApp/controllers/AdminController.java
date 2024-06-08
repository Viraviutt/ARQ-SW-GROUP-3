package com.mvc.EducationApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.EducationApp.dto.AdministradorDTO;
import com.mvc.EducationApp.services.AdminService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/administradores")
@SuppressWarnings("null")
public class AdminController {
    
    @Autowired
    AdminService administradorServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getAdministradores() {

        log.info("Obteniendo todos los administradors");
        HashMap<String, Object> response = new HashMap<>();
        List<AdministradorDTO> administradors = administradorServicio.getAllAdmins();
        response.put("administradors", administradors);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getAdministradorById(@PathVariable("id") Long id) {

        log.info("Obteniendo administrador por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        AdministradorDTO administrador = administradorServicio.getAdminById(id);

        if (administrador == null) {

            response.put("error", "El administrador no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("administrador", administrador);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/* 
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getAdministradorsByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo administrador por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<AdministradorDTO> administradors = administradorServicio.getAdministradorByNombre(nombre);
        response.put("administradors", administradors);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getAdministradorsByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo administrador por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<AdministradorDTO> administrador = administradorServicio.getAdministradorByCorreo(correo);
        
        if (administrador == null) {

            response.put("error", "El administrador no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("administrador", administrador);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getAdministradorsByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo administrador por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<AdministradorDTO> administradors = administradorServicio.getAdministradorByDireccion(direccion);
        response.put("administradors", administradors);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createAdministrador(@RequestBody AdministradorDTO administradorDTO) {

        log.info("Creando el administrador: " + administradorDTO);
        HashMap<String, Object> response = new HashMap<>();
        AdministradorDTO createdAdministrador = administradorServicio.createAdmin(administradorDTO);
        response.put("administrador", createdAdministrador);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateAdministrador(@PathVariable("id") Long id, @RequestBody AdministradorDTO administradorDTO) {

        log.info("Actualizando el administrador: " + administradorDTO);
        HashMap<String, Object> response = new HashMap<>();
        AdministradorDTO updatedAdministrador = administradorServicio.updateAdmin(id, administradorDTO);

        if (updatedAdministrador == null) {

            response.put("error", "Error actualizando el administrador");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("administrador", updatedAdministrador);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteAdministrador(@PathVariable("id") Long id) {

        log.info("Borrando administrador por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (administradorServicio.deleteAdmin(id)) {

            response.put("message", "El administrador ha sido borrado");

        } else {

            response.put("error", "Error al borrar el administrador");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
