package com.mvc.EducationApp.dto;

import com.mvc.EducationApp.entities.Grado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstudianteDTO extends UsuarioDTO{

    private Grado idGrado;
}
