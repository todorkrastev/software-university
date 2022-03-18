package com.manhattan;

import com.manhattan.dtos.EmployeeDetailsDto;
import com.manhattan.services.interfaces.EmployeeService;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConsoleApplication implements CommandLineRunner {
    private final SeedService seedService;
    private final EmployeeService service;

    public ConsoleApplication(SeedService seedService, EmployeeService service) {
        this.seedService = seedService;
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedDataIfNotAny();
        System.out.println(this.service.findOne(1));
        System.out.println(this.service.findManagerOne(1));
        System.out.println(findEmployeesBornBefore1990());
        System.out.println(this.service.findEmployeesManager(2));
    }

    private String findEmployeesBornBefore1990() {
        return this.service.findEmployeesBornBefore(1990)
                .stream()
                .map(EmployeeDetailsDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
