package exam.service.impl;

import exam.model.dto.TownSeedDto;
import exam.model.dto.TownSeedRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.util.FileService;
import exam.util.MessageService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    public static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository repository;
    private final FileService fileService;
    private final MessageService messageService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public TownServiceImpl(TownRepository repository,
                           FileService fileService,
                           MessageService messageService,
                           ValidationUtil validator,
                           ModelMapper mapper) {
        this.repository = repository;
        this.fileService = fileService;
        this.messageService = messageService;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return this.fileService.readString(TOWNS_FILE_PATH);
    }

    @Override
    public String importTowns() throws JAXBException, IOException {
        return this.fileService.readXmlFile(TOWNS_FILE_PATH, TownSeedRootDto.class)
                .getTowns()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Town getTownByName(String name) {
        return this.repository.findByName(name);
    }

    private String persistIfValid(TownSeedDto town) {
        boolean isValid = this.validator.isValid(town, this::isUnique);
        String message = this.messageService.getMessage(town, isValid);
        if (isValid){
            this.repository.save(this.mapper.map(town, Town.class));
        }
        return message;
    }

    private boolean isUnique(TownSeedDto t) {
        return !repository.existsByName(t.getName());
    }
}
