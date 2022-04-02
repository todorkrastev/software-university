package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dto.BestOfferDto;
import softuni.exam.models.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT DISTINCT NEW softuni.exam.models.dto.BestOfferDto(o.agent.firstName, o.agent.lastName, o.id, o.price, o.apartment.area, o.apartment.town.townName) " +
            "FROM Offer o " +
            "WHERE o.apartment.apartmentType = 'three_rooms' " +
            "GROUP BY o " +
            "ORDER BY o.apartment.area DESC, o.price ASC ")
    List<BestOfferDto> findBestOffersByGivenCriteria();
}
