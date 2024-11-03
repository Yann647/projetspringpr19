package sn.supinfo.projetexamen.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.repository.UserRepository;



@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "user/liste")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/liste";
    }

    @RequestMapping(value = "user/ajout")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @RequestMapping(value = "user/edit/{id}")
    public String editUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(null));
        return "user/edite";
    }

    @RequestMapping(value = "user/save")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/liste";
    }

    @RequestMapping(value = "user/update")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/liste";
    }

    @RequestMapping(value = "user/supprimer/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/user/liste";
    }


}
