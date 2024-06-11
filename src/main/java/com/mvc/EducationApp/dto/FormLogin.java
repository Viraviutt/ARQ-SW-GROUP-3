package com.mvc.EducationApp.dto;

import lombok.Data;

@Data
public class FormLogin {
    private String tipo;
    private String correo;
    private String clave;
}