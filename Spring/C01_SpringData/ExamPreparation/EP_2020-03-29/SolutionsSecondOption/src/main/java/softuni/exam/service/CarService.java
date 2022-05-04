package softuni.exam.service;

import softuni.exam.models.entities.Car;

import java.io.IOException;
import java.util.Optional;

public interface CarService {

    boolean areImported();

    String readCarsFileContent() throws IOException;
	
	String importCars() throws IOException;

    String getCarsOrderByPicturesCountThenByMake();

    Optional<Car> getCar(Long id);
}
