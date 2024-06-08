package com.mvc.EducationApp.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class DocenteDTO {

    private Long idDocente;

    private String nombres;

    private String apellidos;

    private String correo;
    
}
