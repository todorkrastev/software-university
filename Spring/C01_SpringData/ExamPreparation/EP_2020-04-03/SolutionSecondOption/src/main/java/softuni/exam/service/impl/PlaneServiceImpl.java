package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PlaneSeedDto;
import softuni.exam.models.dtos.PlaneSeedRootDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {
    public static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";
    private final PlaneRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;


    public PlaneServiceImpl(PlaneRepository repository,
                            FileService fileService,
                            ValidationUtil validator,
                            ModelMapper mapper,
                            MessageService messageService) {
        this.repository = repository;
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
    public String readPlanesFileContent() throws IOException {
        return fileService.readString(PLANES_FILE_PATH);
    }

    @Override
    public String importPlanes() throws JAXBException, IOException {
        return this.fileService.readXmlFile(PLANES_FILE_PATH, PlaneSeedRootDto.class)
                .getPlanes()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<Plane> getByRegisterNumber(String registerNumber) {
        return repository.findByRegisterNumber(registerNumber);
    }

    private String persistIfValid(PlaneSeedDto plane) {
        boolean isValid = this.validator.isValid(plane, this::isUnique);
        String message = this.messageService.getMessage(plane, isValid);
        if (isValid) {
            this.repository.save(this.mapper.map(plane, Plane.class));
        }
        return message;
    }

    private boolean isUnique(PlaneSeedDto plane) {
        return !repository.existsByRegisterNumber(plane.getRegisterNumber());
    }
}
