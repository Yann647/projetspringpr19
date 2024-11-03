package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.service.DTO.EtudiantDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EtudiantMapper {

    public Etudiant toEntity(EtudiantDTO dto) {
        if (dto == null) return null;

        Etudiant entity = new Etudiant();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setMatricule(dto.getMatricule());

        if (dto.getClasseId() != null) {
            Classe classe = new Classe();
            classe.setId(dto.getClasseId());
            entity.setClasse(classe);
        }

        return entity;
    }

    public EtudiantDTO toDto(Etudiant entity) {
        if (entity == null) return null;

        EtudiantDTO dto = new EtudiantDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setMatricule(entity.getMatricule());

        if (entity.getClasse() != null) {
            dto.setClasseId(entity.getClasse().getId());
            dto.setClasseLibelle(entity.getClasse().getLibelle());
        }

        return dto;
    }

    public List<Etudiant> toEntity(List<EtudiantDTO> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }

    public List<EtudiantDTO> toDto(List<Etudiant> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
    }

}
