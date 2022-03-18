package com.manhattan.services.implementations;

import com.manhattan.dtos.EmployeeDetailsDto;
import com.manhattan.dtos.EmployeeDto;
import com.manhattan.dtos.ManagerCustomDto;
import com.manhattan.dtos.ManagerDto;
import com.manhattan.entities.Employee;
import com.manhattan.repositories.EmployeeRepository;
import com.manhattan.services.interfaces.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto findOne(int id) {
        return mapper
                .map(this.repository.findById(id).orElseThrow(),
                        EmployeeDto.class
                );
    }

    @Override
    public ManagerDto findManagerOne(int id) {
        return mapper
                .map(this.repository.findById(id).orElseThrow(),
                        ManagerDto.class
                );
    }

    @Override
    public List<EmployeeDetailsDto> findEmployeesBornBefore(int year) {
        LocalDate targetDate = LocalDate.of(year, 1, 1);
        List<Employee> employees = this.repository.findAllByBirthdayBeforeOrderBySalaryDesc(targetDate);
        return employees
                .stream()
                .map(e -> mapper.map(e, EmployeeDetailsDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public ManagerCustomDto findEmployeesManager(int id) {
        return this.mapper.map(
                this.repository.findById(id).orElseThrow().getManager(),
                ManagerCustomDto.class);
    }
}
