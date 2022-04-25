package com.manhattan.repositories.carDealer;

import com.manhattan.models.carDealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
