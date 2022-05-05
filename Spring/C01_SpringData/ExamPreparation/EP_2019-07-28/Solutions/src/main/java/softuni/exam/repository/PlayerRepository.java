package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
<<<<<<< HEAD
    List<Player> findAllByTeamNameOrderByIdAsc(String name);
=======

    List<Player> findAllByTeamNameOrderByIdAsc(@Param("name")String name);
>>>>>>> 8f0f8805da2b83e06778c8c330b9112db7e52473
    List<Player> findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal salary);
}
