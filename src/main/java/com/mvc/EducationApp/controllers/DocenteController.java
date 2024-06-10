package com.mvc.EducationApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.EducationApp.dto.DocenteDTO;
import com.mvc.EducationApp.services.DocenteService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/docentes")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class DocenteController {
    
    @Autowired
    DocenteService docenteServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getDocentes() {

        log.info("Obteniendo todos los docentes");
        HashMap<String, Object> response = new HashMap<>();
        List<DocenteDTO> docentes = docenteServicio.getAllDocentes();
        response.put("docentes", docentes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getDocenteById(@PathVariable("id") Long id) {

        log.info("Obteniendo docente por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        DocenteDTO docente = docenteServicio.getDocenteById(id);

        if (docente == null) {

            response.put("error", "El docente no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("docente", docente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getDocentesByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo docente por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<DocenteDTO> docentes = docenteServicio.getDocenteByNombre(nombre);
        response.put("docentes", docentes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
/*
    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getDocentesByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo docente por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<DocenteDTO> docente = docenteServicio.getDocenteByCorreo(correo);
        
        if (docente == null) {

            response.put("error", "El docente no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("docente", docente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getDocentesByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo docente por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<DocenteDTO> docentes = docenteServicio.getDocenteByDireccion(direccion);
        response.put("docentes", docentes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createDocente(@RequestBody DocenteDTO docenteDTO) {

        log.info("Creando el docente: " + docenteDTO);
        HashMap<String, Object> response = new HashMap<>();
        DocenteDTO createdDocente = docenteServicio.createDocente(docenteDTO);
        response.put("docente", createdDocente);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateDocente(@PathVariable("id") Long id, @RequestBody DocenteDTO docenteDTO) {

        log.info("Actualizando el docente: " + docenteDTO);
        HashMap<String, Object> response = new HashMap<>();
        DocenteDTO updatedDocente = docenteServicio.updateDocente(id, docenteDTO);

        if (updatedDocente == null) {

            response.put("error", "Error actualizando el docente");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("docente", updatedDocente);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteDocente(@PathVariable("id") Long id) {

        log.info("Borrando docente por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (docenteServicio.deleteDocente(id)) {

            response.put("message", "El docente ha sido borrado");

        } else {

            response.put("error", "Error al borrar el docente");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
