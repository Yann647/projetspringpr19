package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Component;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.service.DTO.ClasseDTO;

@Component
public class ClasseMapper {

    public ClasseDTO toDTO(Classe classe) {
        return new ClasseDTO(
                classe.getId(),
                classe.getNiveau(),
                classe.getSpecialite(),
                classe.getLibelle()
        );
    }

    public Classe toEntity(ClasseDTO classeDTO) {
        Classe classe = new Classe();
        classe.setId(classeDTO.getId());
        classe.setNiveau(classeDTO.getNiveau());
        classe.setSpecialite(classeDTO.getSpecialite());
        classe.generateLibelle(); // Génère automatiquement le libellé
        return classe;
    }

}
