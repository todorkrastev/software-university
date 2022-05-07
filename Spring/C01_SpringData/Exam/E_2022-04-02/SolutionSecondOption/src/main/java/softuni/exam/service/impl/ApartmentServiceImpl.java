package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentSeedDto;
import softuni.exam.models.dto.ApartmentSeedRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    public static final String APARTMENTS_FILE_PATH = "src/main/resources/files/xml/apartments.xml";
    private final ApartmentRepository repository;
    private final TownService townService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository repository,
                                TownService townService,
                                FileService fileService,
                                ValidationUtil validator,
                                MessageService messageService,
                                ModelMapper mapper) {
        this.repository = repository;
        this.townService = townService;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return this.fileService.readString(APARTMENTS_FILE_PATH);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        return this.fileService.readXmlFile(APARTMENTS_FILE_PATH, ApartmentSeedRootDto.class)
                .getApartments()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Apartment> getById(long id) {
        return repository.findOneById(id);
    }

    private String persistIfValid(ApartmentSeedDto apartment) {
        Optional<Town> town = townService.getByTownName(apartment.getTown());
        boolean isValid = this.validator.isValid(apartment, this::isUnique) && town.isPresent();
        String message = this.messageService.getMessage(apartment, isValid);
        if (isValid) {
            Apartment dbApartment= this.mapper.map(apartment, Apartment.class);
            dbApartment.setTown(town.get());
            this.repository.save(dbApartment);
        }
        return message;
    }

    private boolean isUnique(ApartmentSeedDto apartment) {
        return !repository.existsAllByTownTownNameAndArea(apartment.getTown(),apartment.getArea());
    }
}
