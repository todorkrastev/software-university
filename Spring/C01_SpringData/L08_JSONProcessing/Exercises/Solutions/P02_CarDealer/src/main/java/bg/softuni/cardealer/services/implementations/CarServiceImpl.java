package bg.softuni.cardealer.services.implementations;

import bg.softuni.cardealer.constants.GlobalConstant;
import bg.softuni.cardealer.models.dtos.CarSeedDto;
import bg.softuni.cardealer.models.entities.Car;
import bg.softuni.cardealer.models.entities.Part;
import bg.softuni.cardealer.repositories.CarRepository;
import bg.softuni.cardealer.services.CarService;
import bg.softuni.cardealer.services.PartService;
import bg.softuni.cardealer.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;

    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, PartService partService) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
    }


    @Override
    public void seedCars() throws IOException {
        if (this.carRepository.count() == 0) {
            String fileContent = Files.readString(Path.of(GlobalConstant.RESOURCES_FILE_PATH + GlobalConstant.CARS_FILE_NAME));

            CarSeedDto[] carSeedDtos = this.gson.fromJson(fileContent, CarSeedDto[].class);

/*
            Arrays
                    .stream(carSeedDtos)
                    .filter(this.validationUtil::isValid)
                    .map(carSeedDto -> this.modelMapper.map(carSeedDto, Car.class))
                    .peek(carSeedDto -> {

                        Set<Part> randomParts = this.partService.getRandomParts();

                        carSeedDto.setParts(randomParts);

                    })
                    .forEach(this.carRepository::save);
 */

            //TODO: In development
        }
    }
}
