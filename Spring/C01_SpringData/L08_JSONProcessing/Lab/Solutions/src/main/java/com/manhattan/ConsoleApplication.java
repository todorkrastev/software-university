package com.manhattan;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.manhattan.dtos.EmployeeDetailsDto;
import com.manhattan.dtos.EmployeeJsonDto;
import com.manhattan.services.interfaces.EmployeeService;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class ConsoleApplication implements CommandLineRunner {
    private final SeedService seedService;
    private final EmployeeService service;
    private final Gson gson;

    public ConsoleApplication(SeedService seedService, EmployeeService service, Gson gson) {
        this.seedService = seedService;
        this.service = service;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedDataIfNotAny();
        System.out.println(this.service.findOne(1));
        System.out.println(this.service.findManagerOne(1));
        System.out.println(findEmployeesBornBefore1990());
        System.out.println(this.service.findEmployeesManager(2));
        System.out.println(this.gson.toJson(this.service.findEmployeesBornBefore(1990)));

        EmployeeJsonDto[] employees;
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/files/employee.json");
             InputStreamReader streamReader = new InputStreamReader(fileInputStream);
             JsonReader jsonReader = new JsonReader(streamReader)) {
            employees = gson.fromJson(jsonReader, EmployeeJsonDto[].class);
        }
        System.out.println(Arrays.stream(employees)
                .map(EmployeeJsonDto::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private String findEmployeesBornBefore1990() {
        return this.service.findEmployeesBornBefore(1990)
                .stream()
                .map(EmployeeDetailsDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
