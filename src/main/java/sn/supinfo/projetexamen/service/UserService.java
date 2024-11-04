package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.repository.UserRepository;
import sn.supinfo.projetexamen.service.DTO.UserDTO;
import sn.supinfo.projetexamen.service.Mapper.UserMapper;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDTO save(UserDTO userDTO) {

        User user = userMapper.toEntity(userDTO);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }



}
