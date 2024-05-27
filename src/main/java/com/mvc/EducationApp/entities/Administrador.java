package com.mvc.EducationApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "administradores")
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    @Id
    @ManyToOne
    @JoinColumn(name = "idAdmin", referencedColumnName = "idAdmin")
    private Long idAdmin;

}
