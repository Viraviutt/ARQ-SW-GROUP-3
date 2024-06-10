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

import com.mvc.EducationApp.dto.HorarioDTO;
import com.mvc.EducationApp.services.HorarioService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/horarios")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class HorarioController {
    
    @Autowired
    HorarioService horarioServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getHorarios() {

        log.info("Obteniendo todos los horarios");
        HashMap<String, Object> response = new HashMap<>();
        List<HorarioDTO> horarios = horarioServicio.getAllHorarios();
        response.put("horarios", horarios);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getHorarioById(@PathVariable("id") Long id) {

        log.info("Obteniendo horario por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        HorarioDTO horario = horarioServicio.getHorarioById(id);

        if (horario == null) {

            response.put("error", "El horario no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("horario", horario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/* 
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getHorariosByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo horario por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<HorarioDTO> horarios = horarioServicio.getHorarioByNombre(nombre);
        response.put("horarios", horarios);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getHorariosByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo horario por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<HorarioDTO> horario = horarioServicio.getHorarioByCorreo(correo);
        
        if (horario == null) {

            response.put("error", "El horario no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("horario", horario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getHorariosByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo horario por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<HorarioDTO> horarios = horarioServicio.getHorarioByDireccion(direccion);
        response.put("horarios", horarios);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createHorario(@RequestBody HorarioDTO horarioDTO) {

        log.info("Creando el horario: " + horarioDTO);
        HashMap<String, Object> response = new HashMap<>();
        HorarioDTO createdHorario = horarioServicio.createHorario(horarioDTO);
        response.put("horario", createdHorario);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateHorario(@PathVariable("id") Long id, @RequestBody HorarioDTO horarioDTO) {

        log.info("Actualizando el horario: " + horarioDTO);
        HashMap<String, Object> response = new HashMap<>();
        HorarioDTO updatedHorario = horarioServicio.updateHorario(id, horarioDTO);

        if (updatedHorario == null) {

            response.put("error", "Error actualizando el horario");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("horario", updatedHorario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteHorario(@PathVariable("id") Long id) {

        log.info("Borrando horario por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (horarioServicio.deleteHorario(id)) {

            response.put("message", "El horario ha sido borrado");

        } else {

            response.put("error", "Error al borrar el horario");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
