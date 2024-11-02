package sn.supinfo.projetexamen.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.supinfo.projetexamen.service.AgentService;
import sn.supinfo.projetexamen.service.ClasseService;
import sn.supinfo.projetexamen.service.EtudiantService;
import sn.supinfo.projetexamen.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private ClasseService classService;

    @Autowired
    private EtudiantService studentService;

    @GetMapping("/")
    public String gethome(Model model){
        model.addAttribute("userCount", userService.count());
        model.addAttribute("agentCount", agentService.count());
        model.addAttribute("classeCount", classService.count());
        model.addAttribute("etudiantCount", studentService.count());
        return "home";}
}
