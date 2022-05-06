package hiberspring.service.impl;

import hiberspring.domain.dtos.EmployeeCardsSeedDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.FileService;
import hiberspring.util.MessageService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {
    public static final String EMPLOYEE_CARDS_FILE_PATH = "src/main/resources/files/employee-cards.json";
    private final EmployeeCardRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public EmployeeCardServiceImpl(EmployeeCardRepository repository,
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
    public Boolean employeeCardsAreImported() {
        return repository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return fileService.readString(EMPLOYEE_CARDS_FILE_PATH);
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(EMPLOYEE_CARDS_FILE_PATH, EmployeeCardsSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Optional<EmployeeCard> getCardByNumber(String number) {
        return repository.findOneByNumber(number);
    }

    private String persistIfValid(EmployeeCardsSeedDto card) {
        boolean isValid = this.validator.isValid(card, this::isUnique);
        String message = this.messageService.getMessage(card, isValid);

        if (isValid) {
            this.repository.save(mapper.map(card, EmployeeCard.class));
        }

        return message;
    }

    private boolean isUnique(EmployeeCardsSeedDto e) {
        return !repository.existsByNumber(e.getNumber());
    }
}
