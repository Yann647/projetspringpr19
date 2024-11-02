package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ClasseService classeService;

    public long count() {
        return etudiantRepository.count();
    }

    public Etudiant addEtudiant(Etudiant etudiant) {
        String matricule = etudiant.getPrenom().substring(0, 2)
                + etudiant.getNom().substring(0, 2)
                + "ISIKM";
        etudiant.setMatricule(matricule);
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> listEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant.orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));
    }

    public Etudiant updateEtudiant(Long id, Etudiant etudiantDetails) {
        Etudiant etudiant = getEtudiantById(id);
        etudiant.setNom(etudiantDetails.getNom());
        etudiant.setPrenom(etudiantDetails.getPrenom());
        etudiant.setTelephone(etudiantDetails.getTelephone());
        etudiant.setClasse(etudiantDetails.getClasse());
        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Long id) {
        Etudiant etudiant = getEtudiantById(id);
        etudiantRepository.delete(etudiant);
    }


}
