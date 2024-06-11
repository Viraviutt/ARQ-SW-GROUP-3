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
import com.mvc.EducationApp.services.ActividadService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/actividades")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class ActividadController {

    @Autowired
    ActividadService actividadServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getActividads() {

        log.info("Obteniendo todos los actividades");
        HashMap<String, Object> response = new HashMap<>();
        List<ActividadDTO> actividades = actividadServicio.getAllActividades();
        response.put("actividades", actividades);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getActividadById(@PathVariable("id") Long id) {

        log.info("Obteniendo actividad por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        ActividadDTO actividad = actividadServicio.getActividadById(id);

        if (actividad == null) {

            response.put("error", "El actividad no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("actividad", actividad);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/grado/{id}")
    public ResponseEntity<HashMap<String, Object>> getActividadByIdGrado(@PathVariable("id") Long id) {

        log.info("Obteniendo actividad por id de grado: " + id);
        HashMap<String, Object> response = new HashMap<>();
        List<ActividadDTO> actividad = actividadServicio.getActividadByGrado(id);

        if (actividad == null) {

            response.put("error", "El actividad no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("actividad", actividad);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/materia/{materia}/{grado}")
    public ResponseEntity<HashMap<String, Object>> getTemasByMateriasDeGrado(@PathVariable("materia") Long materia, @PathVariable("materia") Long grado) {

        log.info("Obteniendo actividad por materia: " + materia + " y grado: " + grado);
        HashMap<String, Object> response = new HashMap<>();
        List<ActividadDTO> actividades = actividadServicio.getActividadByMateriasAndGradoId(materia, grado);
        response.put("actividades", actividades);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * @GetMapping("/nombre/{nombre}")
     * public ResponseEntity<HashMap<String, Object>>
     * getActividadsByNombre(@PathVariable("nombre") String nombre) {
     * 
     * log.info("Obteniendo actividad por nombre: " + nombre);
     * HashMap<String, Object> response = new HashMap<>();
     * List<ActividadDTO> actividads =
     * actividadServicio.getActividadByNombre(nombre);
     * response.put("actividads", actividads);
     * 
     * return new ResponseEntity<>(response, HttpStatus.OK);
     * }
     * 
     * @GetMapping("/correo/{correo}")
     * public ResponseEntity<HashMap<String, Object>>
     * getActividadsByCorreo(@PathVariable("correo") String correo) {
     * 
     * log.info("Obteniendo actividad por correo: " + correo);
     * HashMap<String, Object> response = new HashMap<>();
     * List<ActividadDTO> actividad =
     * actividadServicio.getActividadByCorreo(correo);
     * 
     * if (actividad == null) {
     * 
     * response.put("error", "El actividad no ha sido encontrado");
     * return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
     * }
     * 
     * response.put("actividad", actividad);
     * return new ResponseEntity<>(response, HttpStatus.OK);
     * }
     * 
     * @GetMapping("/direccion/{direccion}")
     * public ResponseEntity<HashMap<String, Object>>
     * getActividadsByDireccion(@PathVariable("direccion") String direccion) {
     * 
     * log.info("Obteniendo actividad por direccion: " + direccion);
     * HashMap<String, Object> response = new HashMap<>();
     * List<ActividadDTO> actividads =
     * actividadServicio.getActividadByDireccion(direccion);
     * response.put("actividads", actividads);
     * 
     * return new ResponseEntity<>(response, HttpStatus.OK);
     * }
     */
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createActividad(@RequestBody ActividadDTO actividadDTO) {

        log.info("Creando el actividad: " + actividadDTO);
        HashMap<String, Object> response = new HashMap<>();
        ActividadDTO createdActividad = actividadServicio.createActividad(actividadDTO);
        response.put("actividad", createdActividad);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateActividad(@PathVariable("id") Long id,
            @RequestBody ActividadDTO actividadDTO) {

        log.info("Actualizando el actividad: " + actividadDTO);
        HashMap<String, Object> response = new HashMap<>();
        ActividadDTO updatedActividad = actividadServicio.updateActividad(id, actividadDTO);

        if (updatedActividad == null) {

            response.put("error", "Error actualizando el actividad");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("actividad", updatedActividad);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteActividad(@PathVariable("id") Long id) {

        log.info("Borrando actividad por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (actividadServicio.deleteActividad(id)) {

            response.put("message", "El actividad ha sido borrado");

        } else {

            response.put("error", "Error al borrar el actividad");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
