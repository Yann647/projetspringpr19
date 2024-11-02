package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Component;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.service.DTO.EtudiantDTO;

@Component
public class EtudiantMapper {

    public EtudiantDTO toDTO(Etudiant etudiant) {
        EtudiantDTO dto = new EtudiantDTO();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setTelephone(etudiant.getTelephone());
        dto.setMatricule(etudiant.getMatricule());
        dto.setClasseId(etudiant.getClasse().getId());
        return dto;
    }

    public Etudiant toEntity(EtudiantDTO dto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(dto.getId());
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setTelephone(dto.getTelephone());
        etudiant.setMatricule(dto.getMatricule());
        return etudiant;
    }

}
