package com.mvc.EducationApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.EducationApp.dto.AdministradorDTO;
import com.mvc.EducationApp.entities.Administrador;
import com.mvc.EducationApp.mappers.AdminMapper;
import com.mvc.EducationApp.repositories.AdminRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("null")
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdministradorDTO> getAllAdmins() {

        try {

            List<Administrador> admins = adminRepository.findAll();
            return admins.stream().map(AdminMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo todos los admins", e);

        }

        return List.of();

    }

    public AdministradorDTO getAdminById(Long id) {

        try {

            Administrador admin = adminRepository.findById(id).orElse(null);
            return AdminMapper.INSTANCE.toDTO(admin);

        } catch (Exception e) {

            log.error("Error obteniendo admin por id",e);

        }

        return null;
    }

    public Long getCounterAdmin(){

        return adminRepository.count();
    }
/* 
    public List<AdministradorDTO> getAdminByNombre(String nombre) {

        try {

            List<Administrador> admins = adminRepository.findByNombre(nombre).orElse(null);
            return admins.stream().map(AdminMapper.INSTANCE::toDTO).toList();

        } catch (Exception e){

            log.error("Error obteniendo admin por nombre", e);

        }

        return List.of();    
    }

    public List<AdminDTO> getAdminByCorreo(String correo) {

        try {

            List<Admin> admins = adminRepository.findByCorreo(correo).orElse(null);
            return admins.stream().map(AdminMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo admin por email", e);

        }

        return null;
    }

    public List<AdminDTO> getAdminByDireccion(String direccion) {

        try{

            List<Admin> admins = adminRepository.findByDireccion(direccion).orElse(null);
            return admins.stream().map(AdminMapper.INSTANCE::toDTO).toList();

        } catch (Exception e) {

            log.error("Error obteniendo admin por direccion");

        }

        return List.of();
    }
*/
    /*Create, update, delete */
    
    public AdministradorDTO createAdmin(AdministradorDTO adminDTO){

        try {

            if(adminDTO.getIdAdmin() != null) {
                throw new IllegalArgumentException("La id se generará mediante la DB");
            }

            Administrador admin = AdminMapper.INSTANCE.toEntity(adminDTO);
            Administrador savedAdmin = adminRepository.save(admin);

            return AdminMapper.INSTANCE.toDTO(savedAdmin);

        } catch (Exception e) {

            log.error("Error creando admin", e);

        }

        return null;
    }

    public AdministradorDTO updateAdmin(Long id, AdministradorDTO adminDTO) {

        try {

            if (id == null || id < 0) {

                throw new IllegalArgumentException("La id no puede ser nula o menor que cero.");

            }

            Administrador adminAActualizar = adminRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("El admin no existe"));
            Administrador admin = AdminMapper.INSTANCE.toEntity(adminDTO);
            
            admin.setIdAdmin(adminAActualizar.getIdAdmin());

            adminAActualizar = adminRepository.save(admin);

            Administrador savedAdmin = adminRepository.save(adminAActualizar);
            return AdminMapper.INSTANCE.toDTO(savedAdmin);

        } catch (Exception e) {

            log.error("Error actualizando al admin");
            
        }

        return null;
    }

    
    public boolean deleteAdmin(Long id) {

        try {

            adminRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            log.error("Error eliminando el admin");

        }

        return false;
    }
}
