package com.manhattan.services.implementations;

import com.manhattan.entities.Employee;
import com.manhattan.repositories.EmployeeRepository;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SeedServiceImpl implements SeedService {
    private final EmployeeRepository repository;

    @Autowired
    public SeedServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void seedDataIfNotAny() {
        if (databaseIsEmpty()) {
            List<Employee> employee = prepareEmployees();
            this.repository.saveAllAndFlush(employee);
        }
    }

    private List<Employee> prepareEmployees() {
        Employee manager = new Employee(1, "Petar", "Petrov", BigDecimal.valueOf(3000), LocalDate.of(1977, 12, 1), "Burgas", null);
        List<Employee> employees = List.of(
                manager,
                new Employee(2, "Ivan", "Ivanov", BigDecimal.valueOf(2000),
                        LocalDate.of(1977, 12, 1), "Sofia", manager),
                new Employee(3, "Pepa", "Pig", BigDecimal.valueOf(720),
                        LocalDate.of(1977, 12, 1), "Busmantzi", manager),
                new Employee(4, "Zhelio", "Zheliev", BigDecimal.valueOf(2500),
                        LocalDate.of(1977, 12, 1), "Katunitza", manager)
        );

        return employees;
    }

    private boolean databaseIsEmpty() {
        return this.repository.count() == 0;
    }
}
