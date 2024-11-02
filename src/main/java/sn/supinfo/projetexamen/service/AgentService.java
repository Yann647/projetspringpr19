package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.repository.AgentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public long count() {
        return agentRepository.count();
    }

    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> listAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id) {
        Optional<Agent> agent = agentRepository.findById(id);
        return agent.orElseThrow(() -> new RuntimeException("Agent non trouvé"));
    }

    public Agent updateAgent(Long id, Agent agentDetails) {
        Agent agent = getAgentById(id);
        agent.setNom(agentDetails.getNom());
        agent.setPrenom(agentDetails.getPrenom());
        agent.setTelephone(agentDetails.getTelephone());
        agent.setAge(agentDetails.getAge());
        return agentRepository.save(agent);
    }

    public void deleteAgent(Long id) {
        Agent agent = getAgentById(id);
        agentRepository.delete(agent);
    }

}
