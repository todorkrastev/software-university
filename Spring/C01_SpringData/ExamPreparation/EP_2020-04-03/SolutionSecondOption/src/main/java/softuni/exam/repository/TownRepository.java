package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Town;

import java.util.Optional;

@Repository
public interface TownRepository  extends JpaRepository<Town, Long> {

    boolean existsByName(String name);

    Optional<Town> getOneByName(String name);
}
