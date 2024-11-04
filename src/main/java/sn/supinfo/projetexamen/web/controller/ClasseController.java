package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Classe;
import sn.supinfo.projetexamen.repository.ClasseRepository;

@Controller
public class ClasseController {

    private final ClasseRepository classeRepository;

    public ClasseController(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @RequestMapping(value = "classe/liste")
    public String listClasses(Model model) {
        model.addAttribute("classes", classeRepository.findAll());
        return "classe/liste";
    }

    @RequestMapping(value = "classe/ajout")
    public String addClasse(Model model) {
        model.addAttribute("classe", new Classe());
        return "classe/add";
    }

    @RequestMapping(value = "classe/edit/{id}")
    public String editClasse(@PathVariable long id, Model model) {
        model.addAttribute("classe", classeRepository.findById(id).orElse(null));
        return "classe/edite";
    }

    @RequestMapping(value = "classe/save", method = RequestMethod.POST)
    public String saveClasse(@ModelAttribute Classe classe) {
        classeRepository.save(classe);
        return "redirect:/classe/liste";
    }

    @RequestMapping(value = "classe/update")
    public String updateClasse(@ModelAttribute Classe classe) {
        classeRepository.save(classe);
        return "redirect:/classe/liste";
    }

    @RequestMapping(value = "classe/supprimer/{id}")
    public String deleteClasse(@PathVariable long id) {
        classeRepository.deleteById(id);
        return "redirect:/classe/liste";
    }


}
