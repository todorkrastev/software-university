package hiberspring.service.impl;

import hiberspring.domain.dtos.*;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.domain.entities.Product;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.FileService;
import hiberspring.util.MessageService;
import hiberspring.util.ValidationUtil;
import org.hibernate.Cache;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public static final String EMPLOYEES_FILE_PATH = "src/main/resources/files/employees.xml";
    private final EmployeeRepository repository;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public EmployeeServiceImpl(EmployeeRepository repository,
                               BranchService branchService,
                               EmployeeCardService employeeCardService,
                               FileService fileService,
                               ValidationUtil validator,
                               ModelMapper mapper,
                               MessageService messageService) {
        this.repository = repository;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public Boolean employeesAreImported() {
        return repository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return fileService.readString(EMPLOYEES_FILE_PATH);
    }

    @Override
    public String importEmployees() throws JAXBException, IOException {
        return this.fileService.readXmlFile(EMPLOYEES_FILE_PATH, EmployeeSeedRootDto.class)
                .getEmployees()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportProductiveEmployees() {
        return repository.findAllByBranchHavingAtLeastOneProduct()
                .stream()
                .map(e ->mapper.map(e, EmployeeListViewModel.class))
                .map(EmployeeListViewModel::toString)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    private String persistIfValid(EmployeeSeedDto employee) {
        Optional<Branch> branch = branchService.getByName(employee.getBranch());
        Optional<EmployeeCard> card = employeeCardService.getCardByNumber(employee.getCard());
        boolean isValid = this.validator.isValid(employee, this::isUnique) && branch.isPresent() && card.isPresent();
        String message = this.messageService.getMessage(employee, isValid);
        if (isValid) {
            Employee dbEmployee = this.mapper.map(employee, Employee.class);
            dbEmployee.setBranch(branch.get());
            dbEmployee.setCard(card.get());
            this.repository.save(dbEmployee);
        }
        return message;
    }

    private boolean isUnique(EmployeeSeedDto e) {
        return !repository.existsEmployeeByCardNumber(e.getCard());
    }
}
