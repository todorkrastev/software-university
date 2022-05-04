package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    
}
