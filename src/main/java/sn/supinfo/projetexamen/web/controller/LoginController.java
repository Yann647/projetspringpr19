package sn.supinfo.projetexamen.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model){
        User loggedInUser = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if (loggedInUser != null){
            return "redirect:/user/liste";
        } else {
            model.addAttribute("error", "Identifiants invalides");
            return "login";
        }
    }

}
