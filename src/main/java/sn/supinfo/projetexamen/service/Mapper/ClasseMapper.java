package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.service.DTO.ClasseDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClasseMapper {

    public Classe toEntity(ClasseDTO dto) {
        if (dto == null) return null;

        Classe entity = new Classe();
        entity.setId(dto.getId());
        entity.setNiveau(dto.getNiveau());
        entity.setSpecialite(dto.getSpecialite());
        entity.setLibelle(dto.getLibelle());

        return entity;
    }

    public ClasseDTO toDto(Classe entity) {
        if (entity == null) return null;

        ClasseDTO dto = new ClasseDTO();
        dto.setId(entity.getId());
        dto.setNiveau(entity.getNiveau());
        dto.setSpecialite(entity.getSpecialite());
        dto.setLibelle(entity.getLibelle());

        return dto;
    }

    public List<Classe> toEntity(List<ClasseDTO> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }

    public List<ClasseDTO> toDto(List<Classe> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
    }

}
