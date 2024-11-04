package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.constant.Niveau;
import sn.supinfo.projetexamen.constant.Specialite;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.repository.ClasseRepository;
import sn.supinfo.projetexamen.repository.EtudiantRepository;

import java.util.List;


@Controller
public class EtudiantController {

    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;

    public EtudiantController(EtudiantRepository etudiantRepository, ClasseRepository classeRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
    }

    @RequestMapping(value = "etudiant/liste")
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantRepository.findAll());
        return "etudiant/liste";
    }

    @RequestMapping(value = "etudiant/ajout")
    public String addEtudiant(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        List<Classe> classes = classeRepository.findAll();
        model.addAttribute("classes", classes);
        model.addAttribute("niveaux", Niveau.values());
        model.addAttribute("specialites", Specialite.values());
        return "etudiant/add";
    }

    @RequestMapping(value = "etudiant/edit/{id}")
    public String editEtudiant(@PathVariable long id, Model model) {
        model.addAttribute("etudiant", etudiantRepository.findById(id).orElse(null));
        List<Classe> classes = classeRepository.findAll();
        model.addAttribute("classes", classes);
        return "etudiant/edite";
    }

    @RequestMapping(value = "etudiant/save")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/etudiant/liste";
    }

    @RequestMapping(value = "etudiant/update")
    public String updateEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/etudiant/liste";
    }

    @RequestMapping("etudiant/supprimer/{id}")
    public String deleteEtudiant(@PathVariable long id) {
        etudiantRepository.deleteById(id);
        return "redirect:/etudiant/liste";
    }


}
