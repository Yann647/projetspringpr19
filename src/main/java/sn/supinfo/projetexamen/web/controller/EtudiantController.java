package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.repository.EtudiantRepository;


@Controller
public class EtudiantController {

    private final EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @RequestMapping(value = "etudiant/liste")
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantRepository.findAll());
        return "etudiant/liste";
    }

    @RequestMapping(value = "etudiant/ajout")
    public String addEtudiant(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant/add";
    }

    @RequestMapping(value = "etudiant/edit/{id}")
    public String editEtudiant(@PathVariable long id, Model model) {
        model.addAttribute("etudiant", etudiantRepository.findById(id).orElse(null));
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
