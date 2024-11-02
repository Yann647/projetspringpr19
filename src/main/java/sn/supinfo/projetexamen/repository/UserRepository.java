package sn.supinfo.projetexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supinfo.projetexamen.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
