package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Agent;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    boolean existsByFirstName(String firstName);

    boolean existsByEmail(String email);

    Optional<Agent> findByFirstName(String firstName);
}
