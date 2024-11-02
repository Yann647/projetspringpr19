package sn.supinfo.projetexamen.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.service.AgentService;
import sn.supinfo.projetexamen.service.DTO.AgentDTO;
import sn.supinfo.projetexamen.service.Mapper.AgentMapper;
import sn.supinfo.projetexamen.web.rest.AgentResource;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private AgentMapper agentMapper;

    @PostMapping
    public ResponseEntity<AgentDTO> createAgent(@RequestBody AgentDTO agentDTO) {
        Agent agent = agentMapper.toEntity(agentDTO);
        Agent savedAgent = agentService.addAgent(agent);
        return ResponseEntity.ok(agentMapper.toDTO(savedAgent));
    }

    @GetMapping
    public List<AgentDTO> listAgents() {
        return agentService.listAgents()
                .stream()
                .map(agentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentDTO> updateAgent(@PathVariable Long id, @RequestBody AgentDTO agentDTO) {
        Agent agent = agentMapper.toEntity(agentDTO);
        Agent updatedAgent = agentService.updateAgent(id, agent);
        return ResponseEntity.ok(agentMapper.toDTO(updatedAgent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.ok(AgentResource.AGENT_NOT_FOUND);
    }

}
