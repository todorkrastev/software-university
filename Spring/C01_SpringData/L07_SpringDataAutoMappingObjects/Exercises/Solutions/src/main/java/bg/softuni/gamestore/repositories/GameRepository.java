package bg.softuni.gamestore.repositories;

import bg.softuni.gamestore.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findById(Long id);

    Optional<Game> deleteOneById(Long id);

    Optional<Game> findOneByTitle(String title);

    Set<Game> findAllBy();
}
