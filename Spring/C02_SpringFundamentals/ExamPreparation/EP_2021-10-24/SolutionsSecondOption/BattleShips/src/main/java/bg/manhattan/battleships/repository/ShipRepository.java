package bg.manhattan.battleships.repository;

import bg.manhattan.battleships.model.entity.Ship;
import bg.manhattan.battleships.model.view.ShipViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("SELECT new bg.manhattan.battleships.model.view.ShipViewModel(s.id, s.name, s.health, s.power, u.username)" +
            " " +
            "FROM Ship s " +
            "JOIN s.user u")
    List<ShipViewModel> findAllShips();

    Optional<Ship> findByName(String shipName);
}
