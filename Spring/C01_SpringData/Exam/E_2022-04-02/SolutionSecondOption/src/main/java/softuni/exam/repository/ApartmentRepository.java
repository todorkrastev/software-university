package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Apartment;

import java.util.Optional;

@Repository
public interface ApartmentRepository  extends JpaRepository<Apartment, Long> {
    boolean existsAllByTownTownNameAndArea(String townName, double area);

    Optional<Apartment> findOneById(long id);
}
