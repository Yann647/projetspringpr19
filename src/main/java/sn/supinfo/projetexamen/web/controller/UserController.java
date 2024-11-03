package sn.supinfo.projetexamen.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/liste")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/liste";
    }

    @GetMapping("/ajout")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).orElse(null));
        return "user/edite";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/liste";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/liste";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/user/liste";
    }


}
