package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.repository.ClasseRepository;

@Controller
@RequestMapping("classe")
public class ClasseController {

    private final ClasseRepository classeRepository;

    public ClasseController(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @GetMapping("/liste")
    public String listClasses(Model model) {
        model.addAttribute("classes", classeRepository.findAll());
        return "classe/liste";
    }

    @GetMapping("/ajout")
    public String addClasse(Model model) {
        model.addAttribute("classe", new Classe());
        return "classe/add";
    }

    @GetMapping("/edit/{id}")
    public String editClasse(@PathVariable long id, Model model) {
        model.addAttribute("classe", classeRepository.findById(id).orElse(null));
        return "classe/edite";
    }

    @PostMapping("/save")
    public String saveClasse(@ModelAttribute Classe classe) {
        classeRepository.save(classe);
        return "redirect:/classe/liste";
    }

    @PostMapping("/update")
    public String updateClasse(@ModelAttribute Classe classe) {
        classeRepository.save(classe);
        return "redirect:/classe/liste";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteClasse(@PathVariable long id) {
        classeRepository.deleteById(id);
        return "redirect:/classe/liste";
    }


}
