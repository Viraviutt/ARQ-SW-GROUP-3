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

import com.mvc.EducationApp.dto.InformeDTO;
import com.mvc.EducationApp.services.InformeService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/api/v1/informes")
@SuppressWarnings("null")
@CrossOrigin(origins = "*")
public class InformeController {
    
    @Autowired
    InformeService informeServicio;

    @GetMapping("")
    public ResponseEntity<HashMap<String, Object>> getInformes() {

        log.info("Obteniendo todos los informes");
        HashMap<String, Object> response = new HashMap<>();
        List<InformeDTO> informes = informeServicio.getAllInformes();
        response.put("informes", informes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getInformeById(@PathVariable("id") Long id) {

        log.info("Obteniendo informe por id: " + id);
        HashMap<String, Object> response = new HashMap<>();
        InformeDTO informe = informeServicio.getInformeById(id);

        if (informe == null) {

            response.put("error", "El informe no ha sido encontrando");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("informe", informe);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    /*Create, update, delete controllers*/
    @PostMapping("")
    public ResponseEntity<HashMap<String, Object>> createInforme(@RequestBody InformeDTO informeDTO) {

        log.info("Creando el informe: " + informeDTO);
        HashMap<String, Object> response = new HashMap<>();
        InformeDTO createdInforme = informeServicio.createInforme(informeDTO);
        response.put("informe", createdInforme);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateInforme(@PathVariable("id") Long id, @RequestBody InformeDTO informeDTO) {

        log.info("Actualizando el informe: " + informeDTO);
        HashMap<String, Object> response = new HashMap<>();
        InformeDTO updatedInforme = informeServicio.updateInforme(id, informeDTO);

        if (updatedInforme == null) {

            response.put("error", "Error actualizando el informe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

        }

        response.put("informe", updatedInforme);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteInforme(@PathVariable("id") Long id) {

        log.info("Borrando informe por id: " + id);
        HashMap<String, Object> response = new HashMap<>();

        if (informeServicio.deleteInforme(id)) {

            response.put("message", "El informe ha sido borrado");

        } else {

            response.put("error", "Error al borrar el informe");

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
