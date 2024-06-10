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

import com.mvc.EducationApp.dto.GradoDTO;
import com.mvc.EducationApp.services.GradoService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/grados")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class GradoController {
    
    @Autowired
    GradoService gradoServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getGrados() {

        log.info("Obteniendo todos los grados");
        HashMap<String, Object> response = new HashMap<>();
        List<GradoDTO> grados = gradoServicio.getAllGrados();
        response.put("grados", grados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getGradoById(@PathVariable("id") Long id) {

        log.info("Obteniendo grado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        GradoDTO grado = gradoServicio.getGradoById(id);

        if (grado == null) {

            response.put("error", "El grado no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("grado", grado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<HashMap<String, Object>> getGradosByNombre(@PathVariable("nombre") String nombre) {

        log.info("Obteniendo grado por nombre: " + nombre);
        HashMap<String, Object> response = new HashMap<>();
        List<GradoDTO> grados = gradoServicio.getGradoByNombre(nombre);
        response.put("grados", grados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/*     @GetMapping("/correo/{correo}")
    public ResponseEntity<HashMap<String, Object>> getGradosByCorreo(@PathVariable("correo") String correo) {

        log.info("Obteniendo grado por correo: " + correo);
        HashMap<String, Object> response = new HashMap<>();
        List<GradoDTO> grado = gradoServicio.getGradoByCorreo(correo);
        
        if (grado == null) {

            response.put("error", "El grado no ha sido encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        
        response.put("grado", grado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<HashMap<String, Object>> getGradosByDireccion(@PathVariable("direccion") String direccion) {

        log.info("Obteniendo grado por direccion: " + direccion);
        HashMap<String, Object> response = new HashMap<>();
        List<GradoDTO> grados = gradoServicio.getGradoByDireccion(direccion);
        response.put("grados", grados);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createGrado(@RequestBody GradoDTO gradoDTO) {

        log.info("Creando el grado: " + gradoDTO);
        HashMap<String, Object> response = new HashMap<>();
        GradoDTO createdGrado = gradoServicio.createGrado(gradoDTO);
        response.put("grado", createdGrado);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateGrado(@PathVariable("id") Long id, @RequestBody GradoDTO gradoDTO) {

        log.info("Actualizando el grado: " + gradoDTO);
        HashMap<String, Object> response = new HashMap<>();
        GradoDTO updatedGrado = gradoServicio.updateGrado(id, gradoDTO);

        if (updatedGrado == null) {

            response.put("error", "Error actualizando el grado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("grado", updatedGrado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteGrado(@PathVariable("id") Long id) {

        log.info("Borrando grado por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (gradoServicio.deleteGrado(id)) {

            response.put("message", "El grado ha sido borrado");

        } else {

            response.put("error", "Error al borrar el grado");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
