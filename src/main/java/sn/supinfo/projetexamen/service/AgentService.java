package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.repository.AgentRepository;
import sn.supinfo.projetexamen.service.DTO.AgentDTO;
import sn.supinfo.projetexamen.service.Mapper.AgentMapper;


@Service
public class AgentService {

    @Autowired
    private AgentMapper agentMapper;

    @Autowired
    private AgentRepository agentRepository;

    @Transactional
    public AgentDTO save(AgentDTO agentDTO) {
        Agent agent = agentMapper.toEntity(agentDTO);
        return agentMapper.toDto(agentRepository.save(agent));
    }

    public AgentDTO findById(Long id) {
        return agentRepository.findById(id)
                .map(agentMapper::toDto)
                .orElse(null);
    }

}
