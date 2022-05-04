package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.dtos.CarsListDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.FileService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    public static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";
    private final CarRepository repository;
    private final FileService fileService;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    @Autowired
    public CarServiceImpl(CarRepository repository, FileService fileService, ModelMapper mapper, ValidationUtil validator) {
        this.repository = repository;
        this.fileService = fileService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return fileService.readString(CARS_FILE_PATH);
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder response = new StringBuilder();
        this.repository.saveAll(
                Arrays.stream(this.fileService.readJsonFile(CARS_FILE_PATH, CarSeedDto[].class))
                        .map(c -> appendResponseMessage(response, c))
                        .filter(this.validator::isValid)
                        .map(c -> this.mapper.map(c, Car.class))
                        .collect(Collectors.toList()));

        return response.toString().trim();
    }

    private CarSeedDto appendResponseMessage(StringBuilder response, CarSeedDto car) {
        String message;
        if (this.validator.isValid(car)) {
            message = String.format("Successfully imported car - %s %s", car.getMake(), car.getModel());
        } else {
            message = "Invalid car";
        }
        response.append(message).append(System.lineSeparator());
        return car;
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return this.repository.carsOrderByPicturesCountDescOrderByMakeAsc()
                .stream()
                .map(CarsListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Car> getCar(Long id) {
        return this.repository.findById(id);
    }
}
