package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.dtos.CarAndPartsRootDto;
import com.manhattan.models.carDealer.dtos.CarsByMakeRootDto;
import com.manhattan.models.carDealer.entities.Car;

public interface CarService {
    void saveAll(Iterable<Car> cars);

    Car getRandomCar();

    CarsByMakeRootDto getCarsByMake(String make);

    CarAndPartsRootDto getAllCars();

    boolean hasNoRecords();
}
