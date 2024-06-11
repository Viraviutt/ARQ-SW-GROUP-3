package com.mvc.EducationApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountUsers {
    private Long countEstudiantes;
    private Long countDocentes;
    private Long countAdmins;
}
