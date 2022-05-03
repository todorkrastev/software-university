package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PassengerListDto;
import softuni.exam.models.dtos.PassengerSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    public static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";
    private final PassengerRepository repository;
    private final TownService townService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public PassengerServiceImpl(PassengerRepository repository,
                                TownService townService,
                                FileService fileService,
                                ValidationUtil validator,
                                ModelMapper mapper,
                                MessageService messageService) {
        this.repository = repository;
        this.townService = townService;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return fileService.readString(PASSENGERS_FILE_PATH);

    }

    @Override
    public String importPassengers() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(PASSENGERS_FILE_PATH, PassengerSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(PassengerSeedDto passenger) {
        Optional<Town> town = townService.getByName(passenger.getTown());
        boolean isValid = this.validator.isValid(passenger, this::isUnique) && town.isPresent();
        String message = this.messageService.getMessage(passenger, isValid);

        if (isValid) {
            Passenger dbPassenger = this.mapper.map(passenger, Passenger.class);
            dbPassenger.setTown(town.get());
            this.repository.save(dbPassenger);
        }

        return message;
    }

    private boolean isUnique(PassengerSeedDto c) {
        return !repository.existsByEmail(c.getEmail());
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        return repository.findAllPassengersOrderByTicketsSizeDescAndEmailAsc()
                .stream()
                .map(PassengerListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    @Override
    public Optional<Passenger> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
