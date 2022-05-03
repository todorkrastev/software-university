package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dtos.PassengerListDto;
import softuni.exam.models.entities.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository  extends JpaRepository<Passenger, Long> {

    boolean existsByEmail(String email);

    Optional<Passenger> findByEmail(String email);

    @Query("SELECT NEW softuni.exam.models.dtos.PassengerListDto " +
            "(p.firstName, p.lastName, p.email, p.phoneNumber, SIZE(p.tickets)) " +
            "FROM Passenger p " +
            "GROUP BY p " +
            "ORDER BY SIZE(p.tickets) DESC, p.email ASC ")
    List<PassengerListDto> findAllPassengersOrderByTicketsSizeDescAndEmailAsc();
}
