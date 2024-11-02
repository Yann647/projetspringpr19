package sn.supinfo.projetexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supinfo.projetexamen.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long > {
}
