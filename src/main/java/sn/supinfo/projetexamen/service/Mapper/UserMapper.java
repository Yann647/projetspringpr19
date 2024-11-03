package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.service.DTO.UserDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;

        User entity = new User();
        entity.setId(dto.getId());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setTelephone(dto.getTelephone());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    public UserDTO toDto(User entity) {
        if (entity == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setEmail(entity.getEmail());
        dto.setTelephone(entity.getTelephone());
        dto.setLogin(entity.getLogin());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public List<User> toEntity(List<UserDTO> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }

    public List<UserDTO> toDto(List<User> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
    }

}
