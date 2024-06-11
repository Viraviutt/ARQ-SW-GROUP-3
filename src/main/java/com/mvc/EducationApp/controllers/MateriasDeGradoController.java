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

import com.mvc.EducationApp.dto.MateriasDeGradoDTO;
import com.mvc.EducationApp.services.MateriasDeGradoService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/materias_de_grado")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class MateriasDeGradoController {
    
    @Autowired
    MateriasDeGradoService materiasDeGradoServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getMateriasDeGrados() {

        log.info("Obteniendo todos los materiasDeGrados");
        HashMap<String, Object> response = new HashMap<>();
        List<MateriasDeGradoDTO> materiasDeGrados = materiasDeGradoServicio.getAllMateriasDeGrados();
        response.put("materiasDeGrados", materiasDeGrados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getMateriasDeGradoById(@PathVariable("id") Long id) {

        log.info("Obteniendo materiasDeGrado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        MateriasDeGradoDTO materiasDeGrado = materiasDeGradoServicio.getMateriasDeGradoById(id);

        if (materiasDeGrado == null) {

            response.put("error", "El materiasDeGrado no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("materiasDeGrado", materiasDeGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<HashMap<String, Object>> getMateriasDeGradoByIdEstudiantes(@PathVariable("id") Long id) {

        log.info("Obteniendo materiasDeGrado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        List<MateriasDeGradoDTO> materiasDeGrado = materiasDeGradoServicio.getMateriasDeGradoByStudentId(id);

        if (materiasDeGrado == null) {

            response.put("error", "El materiasDeGrado no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("materiasDeGrado", materiasDeGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    /*Create, update, delete controllers*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createMateriasDeGrado(@RequestBody MateriasDeGradoDTO materiasDeGradoDTO) {

        log.info("Creando el materiasDeGrado: " + materiasDeGradoDTO);
        HashMap<String, Object> response = new HashMap<>();
        MateriasDeGradoDTO createdMateriasDeGrado = materiasDeGradoServicio.createMateriasDeGrado(materiasDeGradoDTO);
        response.put("materiasDeGrado", createdMateriasDeGrado);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateMateriasDeGrado(@PathVariable("id") Long id, @RequestBody MateriasDeGradoDTO materiasDeGradoDTO) {

        log.info("Actualizando el materiasDeGrado: " + materiasDeGradoDTO);
        HashMap<String, Object> response = new HashMap<>();
        MateriasDeGradoDTO updatedMateriasDeGrado = materiasDeGradoServicio.updateMateriasDeGrado(id, materiasDeGradoDTO);

        if (updatedMateriasDeGrado == null) {

            response.put("error", "Error actualizando el materiasDeGrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("materiasDeGrado", updatedMateriasDeGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteMateriasDeGrado(@PathVariable("id") Long id) {

        log.info("Borrando materiasDeGrado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (materiasDeGradoServicio.deleteMateriasDeGrado(id)) {

            response.put("message", "El materiasDeGrado ha sido borrado");

        } else {

            response.put("error", "Error al borrar el materiasDeGrado");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
