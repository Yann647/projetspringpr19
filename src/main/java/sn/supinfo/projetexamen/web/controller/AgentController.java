package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.repository.AgentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("agent")
public class AgentController {

    private final AgentRepository agentRepository;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @GetMapping("/liste")
    public String listAgents(Model model) {
        model.addAttribute("agents", agentRepository.findAll());
        return "agent/liste";
    }

    @GetMapping("/ajout")
    public String addAgent(Model model) {
        model.addAttribute("agent", new Agent());
        return "agent/add";
    }

    @GetMapping("/edit/{id}")
    public String editAgent(@PathVariable long id, Model model) {
        model.addAttribute("agent", agentRepository.findById(id).orElse(null));
        return "agent/edite";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute Agent agent) {
        agentRepository.save(agent);
        return "redirect:/agent/liste";
    }

    @PostMapping("/update")
    public String updateAgent(@ModelAttribute Agent agent) {
        agentRepository.save(agent);
        return "redirect:/agent/liste";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteAgent(@PathVariable long id) {
        agentRepository.deleteById(id);
        return "redirect:/agent/liste";
    }


}
