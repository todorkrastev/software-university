package bg.softuni.automappingobjects;

import bg.softuni.automappingobjects.models.dto.ManagerDto;
import bg.softuni.automappingobjects.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final EmployeeService employeeService;

    public CommandLineRunnerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        ManagerDto managerDto = this.employeeService.findOne(1L);
        System.out.println(managerDto.getFirstName() + " " + managerDto.getLastName() + ":");
        managerDto.getSubordinates().forEach(employeeDto -> {
            System.out.println("\t" + employeeDto.getFirstName() + " " + employeeDto.getLastName() + ": " + employeeDto.getSalary());
        });
         */

        List<ManagerDto> managers = this.employeeService.findAll();
        managers.forEach(managerDto -> {
            System.out.println(managerDto.getFirstName() + " " + managerDto.getLastName() + ":");
            managerDto.getSubordinates().forEach(employeeDto -> {
                System.out.println("\t" + employeeDto.getFirstName() + " " + employeeDto.getLastName() + ": " + employeeDto.getSalary());
            });
        });
    }
}
