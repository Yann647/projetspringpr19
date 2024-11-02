package sn.supinfo.projetexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.supinfo.projetexamen.model.User;
import sn.supinfo.projetexamen.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public long count() {
        return userRepository.count();
    }

    public User addUser(User user){

        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setTelephone(userDetails.getTelephone());
        user.setEmail(userDetails.getEmail());
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }


}
