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

import com.mvc.EducationApp.dto.DocentesDeGradoDTO;
import com.mvc.EducationApp.services.DocentesDeGradoService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/docentes_de_grado")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class DocentesDeGradoController {
    
    @Autowired
    DocentesDeGradoService docentesDeGradoServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getDocentesDeGrados() {

        log.info("Obteniendo todos los docentesDeGrados");
        HashMap<String, Object> response = new HashMap<>();
        List<DocentesDeGradoDTO> docentesDeGrados = docentesDeGradoServicio.getAllDocentesDeGrados();
        response.put("docentesDeGrados", docentesDeGrados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getDocentesDeGradoById(@PathVariable("id") Long id) {

        log.info("Obteniendo docentesDeGrado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        DocentesDeGradoDTO docentesDeGrado = docentesDeGradoServicio.getDocentesDeGradoById(id);

        if (docentesDeGrado == null) {

            response.put("error", "El docentesDeGrado no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("docentesDeGrado", docentesDeGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/* 
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getDocentesDeGradosByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo docentesDeGrado por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<DocentesDeGradoDTO> docentesDeGrados = docentesDeGradoServicio.getDocentesDeGradoByNombre(nombre);
        response.put("docentesDeGrados", docentesDeGrados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getDocentesDeGradosByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo docentesDeGrado por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<DocentesDeGradoDTO> docentesDeGrado = docentesDeGradoServicio.getDocentesDeGradoByCorreo(correo);
        
        if (docentesDeGrado == null) {

            response.put("error", "El docentesDeGrado no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("docentesDeGrado", docentesDeGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getDocentesDeGradosByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo docentesDeGrado por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<DocentesDeGradoDTO> docentesDeGrados = docentesDeGradoServicio.getDocentesDeGradoByDireccion(direccion);
        response.put("docentesDeGrados", docentesDeGrados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createDocentesDeGrado(@RequestBody DocentesDeGradoDTO docentesDeGradoDTO) {

        log.info("Creando el docentesDeGrado: " + docentesDeGradoDTO);
        HashMap<String, Object> response = new HashMap<>();
        DocentesDeGradoDTO createdDocentesDeGrado = docentesDeGradoServicio.createDocentesDeGrado(docentesDeGradoDTO);
        response.put("docentesDeGrado", createdDocentesDeGrado);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateDocentesDeGrado(@PathVariable("id") Long id, @RequestBody DocentesDeGradoDTO docentesDeGradoDTO) {

        log.info("Actualizando el docentesDeGrado: " + docentesDeGradoDTO);
        HashMap<String, Object> response = new HashMap<>();
        DocentesDeGradoDTO updatedDocentesDeGrado = docentesDeGradoServicio.updateDocentesDeGrado(id, docentesDeGradoDTO);

        if (updatedDocentesDeGrado == null) {

            response.put("error", "Error actualizando el docentesDeGrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("docentesDeGrado", updatedDocentesDeGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteDocentesDeGrado(@PathVariable("id") Long id) {

        log.info("Borrando docentesDeGrado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (docentesDeGradoServicio.deleteDocentesDeGrado(id)) {

            response.put("message", "El docentesDeGrado ha sido borrado");

        } else {

            response.put("error", "Error al borrar el docentesDeGrado");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
