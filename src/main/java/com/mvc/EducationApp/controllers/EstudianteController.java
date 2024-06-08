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

import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.services.EstudianteService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/estudiantes")
@SuppressWarnings("null")
public class EstudianteController {
    
    @Autowired
    EstudianteService estudianteServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getEstudiantes() {

        log.info("Obteniendo todos los estudiantes");
        HashMap<String, Object> response = new HashMap<>();
        List<EstudianteDTO> estudiantes = estudianteServicio.getAllEstudiantes();
        response.put("estudiantes", estudiantes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getEstudianteById(@PathVariable("id") Long id) {

        log.info("Obteniendo estudiante por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        EstudianteDTO estudiante = estudianteServicio.getEstudianteById(id);

        if (estudiante == null) {

            response.put("error", "El estudiante no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("estudiante", estudiante);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/* 
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getEstudiantesByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo estudiante por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<EstudianteDTO> estudiantes = estudianteServicio.getEstudianteByNombre(nombre);
        response.put("estudiantes", estudiantes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getEstudiantesByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo estudiante por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<EstudianteDTO> estudiante = estudianteServicio.getEstudianteByCorreo(correo);
        
        if (estudiante == null) {

            response.put("error", "El estudiante no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("estudiante", estudiante);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getEstudiantesByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo estudiante por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<EstudianteDTO> estudiantes = estudianteServicio.getEstudianteByDireccion(direccion);
        response.put("estudiantes", estudiantes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createEstudiante(@RequestBody EstudianteDTO estudianteDTO) {

        log.info("Creando el estudiante: " + estudianteDTO);
        HashMap<String, Object> response = new HashMap<>();
        EstudianteDTO createdEstudiante = estudianteServicio.createEstudiante(estudianteDTO);
        response.put("estudiante", createdEstudiante);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateEstudiante(@PathVariable("id") Long id, @RequestBody EstudianteDTO estudianteDTO) {

        log.info("Actualizando el estudiante: " + estudianteDTO);
        HashMap<String, Object> response = new HashMap<>();
        EstudianteDTO updatedEstudiante = estudianteServicio.updateEstudiante(id, estudianteDTO);

        if (updatedEstudiante == null) {

            response.put("error", "Error actualizando el estudiante");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("estudiante", updatedEstudiante);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteEstudiante(@PathVariable("id") Long id) {

        log.info("Borrando estudiante por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (estudianteServicio.deleteEstudiante(id)) {

            response.put("message", "El estudiante ha sido borrado");

        } else {

            response.put("error", "Error al borrar el estudiante");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
