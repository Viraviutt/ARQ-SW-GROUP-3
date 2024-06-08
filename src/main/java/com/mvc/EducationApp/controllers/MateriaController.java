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

import com.mvc.EducationApp.dto.MateriaDTO;
import com.mvc.EducationApp.services.MateriaService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/materias")
@SuppressWarnings("null")
public class MateriaController {
    
    @Autowired
    MateriaService materiaServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getMaterias() {

        log.info("Obteniendo todos los materias");
        HashMap<String, Object> response = new HashMap<>();
        List<MateriaDTO> materias = materiaServicio.getAllMaterias();
        response.put("materias", materias);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getMateriaById(@PathVariable("id") Long id) {

        log.info("Obteniendo materia por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        MateriaDTO materia = materiaServicio.getMateriaById(id);

        if (materia == null) {

            response.put("error", "El materia no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("materia", materia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/* 
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getMateriasByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo materia por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<MateriaDTO> materias = materiaServicio.getMateriaByNombre(nombre);
        response.put("materias", materias);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getMateriasByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo materia por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<MateriaDTO> materia = materiaServicio.getMateriaByCorreo(correo);
        
        if (materia == null) {

            response.put("error", "El materia no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("materia", materia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getMateriasByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo materia por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<MateriaDTO> materias = materiaServicio.getMateriaByDireccion(direccion);
        response.put("materias", materias);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createMateria(@RequestBody MateriaDTO materiaDTO) {

        log.info("Creando el materia: " + materiaDTO);
        HashMap<String, Object> response = new HashMap<>();
        MateriaDTO createdMateria = materiaServicio.createMateria(materiaDTO);
        response.put("materia", createdMateria);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateMateria(@PathVariable("id") Long id, @RequestBody MateriaDTO materiaDTO) {

        log.info("Actualizando el materia: " + materiaDTO);
        HashMap<String, Object> response = new HashMap<>();
        MateriaDTO updatedMateria = materiaServicio.updateMateria(id, materiaDTO);

        if (updatedMateria == null) {

            response.put("error", "Error actualizando el materia");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("materia", updatedMateria);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteMateria(@PathVariable("id") Long id) {

        log.info("Borrando materia por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (materiaServicio.deleteMateria(id)) {

            response.put("message", "El materia ha sido borrado");

        } else {

            response.put("error", "Error al borrar el materia");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
