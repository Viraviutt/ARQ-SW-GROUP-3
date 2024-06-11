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

import com.mvc.EducationApp.dto.ActividadDTO;
import com.mvc.EducationApp.dto.TemaDTO;
import com.mvc.EducationApp.services.TemaService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/temas")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class TemaController {
    
    @Autowired
    TemaService temaServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getTemas() {

        log.info("Obteniendo todos los temas");
        HashMap<String, Object> response = new HashMap<>();
        List<TemaDTO> temas = temaServicio.getAllTemas();
        response.put("temas", temas);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getTemaById(@PathVariable("id") Long id) {

        log.info("Obteniendo tema por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        TemaDTO tema = temaServicio.getTemaById(id);

        if (tema == null) {

            response.put("error", "El tema no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("tema", tema);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/grado/{id}")
    public ResponseEntity<HashMap<String, Object>> getTemaByIdGrado(@PathVariable("id") Long id) {

        log.info("Obteniendo temas por id de grado: " + id);
        HashMap<String, Object> response = new HashMap<>();
        List<TemaDTO> temas = temaServicio.getTemaByGrado(id);

        if (temas == null) {

            response.put("error", "El actividad no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("temas", temas);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @GetMapping("/materia/{materia}/{grado}")
    public ResponseEntity<HashMap<String, Object>> getTemasByMateriasDeGrado(@PathVariable("materia") Long materia, @PathVariable("materia") Long grado) {

        log.info("Obteniendo tema por materia: " + materia + "y grado: " + grado);
        HashMap<String, Object> response = new HashMap<>();
        List<TemaDTO> temas = temaServicio.getTemaByMateriasAndGradoId(materia, grado);
        response.put("temas", temas);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

/*
    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getTemasByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo tema por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<TemaDTO> tema = temaServicio.getTemaByCorreo(correo);
        
        if (tema == null) {

            response.put("error", "El tema no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("tema", tema);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getTemasByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo tema por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<TemaDTO> temas = temaServicio.getTemaByDireccion(direccion);
        response.put("temas", temas);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createTema(@RequestBody TemaDTO temaDTO) {

        log.info("Creando el tema: " + temaDTO);
        HashMap<String, Object> response = new HashMap<>();
        TemaDTO createdTema = temaServicio.createTema(temaDTO);
        response.put("tema", createdTema);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateTema(@PathVariable("id") Long id, @RequestBody TemaDTO temaDTO) {

        log.info("Actualizando el tema: " + temaDTO);
        HashMap<String, Object> response = new HashMap<>();
        TemaDTO updatedTema = temaServicio.updateTema(id, temaDTO);

        if (updatedTema == null) {

            response.put("error", "Error actualizando el tema");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("tema", updatedTema);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteTema(@PathVariable("id") Long id) {

        log.info("Borrando tema por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (temaServicio.deleteTema(id)) {

            response.put("message", "El tema ha sido borrado");

        } else {

            response.put("error", "Error al borrar el tema");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
