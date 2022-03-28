package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.PassengerListDto;
import softuni.exam.models.dto.PassengerSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        PassengerSeedDto[] dtos = this.gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class);

        Arrays
                .stream(dtos)
                .filter(passengerSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(passengerSeedDto) &&
                            !doesEntityExist(passengerSeedDto.getEmail()) &&
                            this.townService.doesEntityExist(passengerSeedDto.getTown());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Passenger %s - %s",
                                            passengerSeedDto.getLastName(),
                                            passengerSeedDto.getEmail()) :
                                    "Invalid Passenger")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(passengerSeedDto -> {
                    Passenger passenger = this.modelMapper.map(passengerSeedDto, Passenger.class);

                    String townName = passengerSeedDto.getTown();
                    Town town = this.townService.findByName(townName);
                    passenger.setTown(town);

                    return passenger;
                })
                .forEach(this.passengerRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String email) {
        return this.passengerRepository.existsByEmail(email);
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        List<PassengerListDto> passengers = this.passengerRepository.findAllByOrderByTicketsCountDescThenEmailAsc();

        return passengers
                .stream()
                .map(PassengerListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Passenger findByEmail(String email) {
        return this.passengerRepository.findByEmail(email).orElse(null);
    }
}
