package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.Agent;
import sn.supinfo.projetexamen.service.DTO.AgentDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AgentMapper {

    public Agent toEntity(AgentDTO dto) {
        if (dto == null) return null;

        Agent entity = new Agent();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setTelephone(dto.getTelephone());
        entity.setAge(dto.getAge());

        return entity;
    }

    public AgentDTO toDto(Agent entity) {
        if (entity == null) return null;

        AgentDTO dto = new AgentDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setTelephone(entity.getTelephone());
        dto.setAge(entity.getAge());

        return dto;
    }

    public List<Agent> toEntity(List<AgentDTO> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }

    public List<AgentDTO> toDto(List<Agent> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
    }

}
