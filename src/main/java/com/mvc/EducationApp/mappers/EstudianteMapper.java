package com.mvc.EducationApp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mvc.EducationApp.dto.EstudianteDTO;
import com.mvc.EducationApp.entities.Estudiante;
import com.mvc.EducationApp.repositories.EstudianteRepository;
import com.mvc.EducationApp.repositories.GradoRepository;

@Mapper
public interface EstudianteMapper {
    
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(source = "idGrado.idGrado", target = "idGrado")
    public EstudianteDTO toDTO(Estudiante estudiante);

//    @Mapping(target = "idGrado", ignore = true)
//    public Estudiante toEntity(EstudianteDTO estudianteDTO);

    default Estudiante toEntity(EstudianteDTO estudianteDTO, EstudianteRepository estudianteRepository, GradoRepository gradoRepository){
        
        if (estudianteDTO == null) {
            return null;
        }

        Estudiante estudiante = new Estudiante();

        Long id = estudianteDTO.getIdGrado();
        estudiante.setIdGrado(gradoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Grado no encontrado con la ID: " + estudianteDTO.getIdGrado())));
        estudiante.setNombres(estudianteDTO.getNombres());
        estudiante.setApellidos(estudianteDTO.getApellidos());
        estudiante.setCorreo(estudianteDTO.getCorreo());
        estudiante.setEstado(estudianteDTO.getEstado());
        estudiante.setClave(estudianteDTO.getClave());
        
        return estudiante;
    }
}
