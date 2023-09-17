package bg.manhattan.heroes.repository;

import bg.manhattan.heroes.model.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HeroRepository extends JpaRepository<Hero, UUID> {
    Optional<Hero> findByName(String heroName);

    List<Hero> findAllByOrderByLevelDesc();
}
