package sn.supinfo.projetexamen.service.Mapper;

import org.springframework.stereotype.Component;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.service.DTO.UserDTO;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setPrenom(user.getPrenom());
        dto.setTelephone(user.getTelephone());
        dto.setEmail(user.getEmail());
        dto.setLogin(user.getLogin());
        return dto;
    }

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setNom(dto.getNom());
        user.setPrenom(dto.getPrenom());
        user.setTelephone(dto.getTelephone());
        user.setEmail(dto.getEmail());
        user.setLogin(dto.getLogin());
        return user;
    }

}
