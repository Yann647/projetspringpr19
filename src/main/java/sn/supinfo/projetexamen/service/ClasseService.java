package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.repository.ClasseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public long count() {
        return classeRepository.count();
    }

    public Classe addClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public List<Classe> listClasses() {
        return classeRepository.findAll();
    }

    public Classe getClasseById(Long id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.orElseThrow(() -> new RuntimeException("Classe non trouvée"));
    }

    public Classe updateClasse(Long id, Classe classeDetails) {
        Classe classe = getClasseById(id);
        classe.setNiveau(classeDetails.getNiveau());
        classe.setSpecialite(classeDetails.getSpecialite());
        classe.generateLibelle(); // Met à jour automatiquement le libellé
        return classeRepository.save(classe);
    }

    public void deleteClasse(Long id) {
        Classe classe = getClasseById(id);
        classeRepository.delete(classe);
    }

}
