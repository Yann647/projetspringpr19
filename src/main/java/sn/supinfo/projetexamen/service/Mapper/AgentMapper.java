package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Component;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.service.DTO.AgentDTO;

@Component
public class AgentMapper {
    public AgentDTO toDTO(Agent agent) {
        AgentDTO dto = new AgentDTO();
        dto.setId(agent.getId());
        dto.setNom(agent.getNom());
        dto.setPrenom(agent.getPrenom());
        dto.setTelephone(agent.getTelephone());
        dto.setAge(agent.getAge());
        return dto;
    }

    public Agent toEntity(AgentDTO dto) {
        Agent agent = new Agent();
        agent.setId(dto.getId());
        agent.setNom(dto.getNom());
        agent.setPrenom(dto.getPrenom());
        agent.setTelephone(dto.getTelephone());
        agent.setAge(dto.getAge());
        return agent;
    }

}
