package bg.softuni.automappingobjects.services.implementations;

import bg.softuni.automappingobjects.models.dto.ManagerDto;
import bg.softuni.automappingobjects.models.entities.Employee;
import bg.softuni.automappingobjects.repositories.EmployeeRepository;
import bg.softuni.automappingobjects.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public ManagerDto findOne(Long id) {
        Employee employee = this.employeeRepository
                .findById(id)
                .orElseThrow();

        return this.mapper.map(employee, ManagerDto.class);
    }

    @Override
    public List<ManagerDto> findAll() {
        List<Employee> employees = this.employeeRepository
                 .findAll();

        return this.mapper.map(
                employees,
                new TypeToken<List<ManagerDto>>() {
                }.getType()
        );
    }
}
