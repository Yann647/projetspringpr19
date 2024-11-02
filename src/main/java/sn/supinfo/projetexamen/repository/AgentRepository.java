package sn.supinfo.projetexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supinfo.projetexamen.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
