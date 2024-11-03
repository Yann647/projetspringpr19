package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Etudiant;
import sn.supinfo.projetexamen.repository.EtudiantRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("etudiant")
public class EtudiantController {

    private final EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @GetMapping("/liste")
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", etudiantRepository.findAll());
        return "etudiant/liste";
    }

    @GetMapping("/ajout")
    public String addEtudiant(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant/add";
    }

    @GetMapping("/edit/{id}")
    public String editEtudiant(@PathVariable long id, Model model) {
        model.addAttribute("etudiant", etudiantRepository.findById(id).orElse(null));
        return "etudiant/edite";
    }

    @PostMapping("/save")
    public String saveEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/etudiant/liste";
    }

    @PostMapping("/update")
    public String updateEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/etudiant/liste";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteEtudiant(@PathVariable long id) {
        etudiantRepository.deleteById(id);
        return "redirect:/etudiant/liste";
    }


}
