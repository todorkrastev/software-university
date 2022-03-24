package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files
                .readString(Path.of(GlobalConstant.CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        CarSeedDto[] carSeedDtos = this.gson.fromJson(readCarsFileContent(), CarSeedDto[].class);

        Arrays
                .stream(carSeedDtos)
                .filter(carSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(carSeedDto);
                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported car - %s - %s",
                                    carSeedDto.getMake(), carSeedDto.getModel())
                                    : "Invalid car")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(carSeedDto -> this.modelMapper.map(carSeedDto, Car.class))
                .forEach(this.carRepository::save);


        /*
        List<Car> cars = Arrays.stream(carSeedDtos)
                .filter(validationUtil::isValid)
                .map(carSeedDto -> this.modelMapper.map(carSeedDto, Car.class))
                .collect(Collectors.toList());
         */

        return stringBuilder.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder stringBuilder = new StringBuilder();

        this.carRepository
                .findCarsOrderByPicturesCountDescThenByMakeAsc()
                .forEach(car -> stringBuilder
                        .append(String.format("Car make - %s, model - %s\n" +
                                        "\tKilometers - %d\n" +
                                        "\tRegistered on - %s\n" +
                                        "\tNumber of pictures - %d",
                                car.getMake(),
                                car.getModel(),
                                car.getKilometers(),
                                car.getRegisteredOn(),
                                car.getPictures().size()))
                        .append(System.lineSeparator()));

        return stringBuilder.toString();
    }

    @Override
    public Car findById(Long id) {
        return this.carRepository.findById(id).orElse(null);
    }
}
