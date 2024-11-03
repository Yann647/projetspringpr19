package sn.supinfo.projetexamen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.repository.AgentRepository;


@Controller
public class AgentController {

    private final AgentRepository agentRepository;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @RequestMapping(value = "agent/liste")
    public String listAgents(Model model) {
        model.addAttribute("agents", agentRepository.findAll());
        return "agent/liste";
    }

    @RequestMapping(value = "agent/ajout")
    public String addAgent(Model model) {
        model.addAttribute("agent", new Agent());
        return "agent/add";
    }

    @RequestMapping(value = "agent/edit/{id}")
    public String editAgent(@PathVariable long id, Model model) {
        model.addAttribute("agent", agentRepository.findById(id).orElse(null));
        return "agent/edite";
    }

    @RequestMapping(value = "agent/save")
    public String saveAgent(@ModelAttribute Agent agent) {
        agentRepository.save(agent);
        return "redirect:/agent/liste";
    }

    @RequestMapping(value = "agent/update")
    public String updateAgent(@ModelAttribute Agent agent) {
        agentRepository.save(agent);
        return "redirect:/agent/liste";
    }

    @RequestMapping(value = "agent/supprimer/{id}")
    public String deleteAgent(@PathVariable long id) {
        agentRepository.deleteById(id);
        return "redirect:/agent/liste";
    }


}
