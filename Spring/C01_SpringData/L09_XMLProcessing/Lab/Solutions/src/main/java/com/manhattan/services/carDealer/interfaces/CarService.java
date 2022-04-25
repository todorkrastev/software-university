package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.dtos.CarAndPartsDto;
import com.manhattan.models.carDealer.dtos.CarsByMakeDto;
import com.manhattan.models.carDealer.entities.Car;

import java.util.List;

public interface CarService {
    void saveAll(Iterable<Car> cars);

    Car getRandomCar();

    List<CarsByMakeDto> getCarsByMake(String make);

    List<CarAndPartsDto> getAllCars();
}
