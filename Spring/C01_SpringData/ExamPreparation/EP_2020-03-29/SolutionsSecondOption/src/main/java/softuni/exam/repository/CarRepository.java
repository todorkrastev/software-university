package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dtos.CarsListDto;
import softuni.exam.models.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT NEW softuni.exam.models.dtos.CarsListDto(c.make, c.model, c.kilometers, " +
            "c.registeredOn, size(c.pictures)) " +
            "FROM Car c " +
            "GROUP BY c " +
            "ORDER BY size(c.pictures) DESC, c.make ASC")
    List<CarsListDto> carsOrderByPicturesCountDescOrderByMakeAsc();
}
