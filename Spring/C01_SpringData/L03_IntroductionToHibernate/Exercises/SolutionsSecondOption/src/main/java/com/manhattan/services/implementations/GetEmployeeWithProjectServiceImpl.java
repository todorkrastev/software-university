package com.manhattan.services.implementations;

import com.manhattan.entities.Employee;
import com.manhattan.entities.Project;

import javax.persistence.EntityManager;

import java.io.IOException;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.*;

/**
 * 8.	Get Employee with Project
 */
public class GetEmployeeWithProjectServiceImpl extends BaseServiceImpl {

    public GetEmployeeWithProjectServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        try {
            int employeeId = readIntFromConsole("Enter employee's ID: ");
            Employee employee = this.entityManager.find(Employee.class, employeeId);
            printResultMessage(
                    String.format("%s %s - %s",
                            employee.getFirstName(), employee.getLastName(), employee.getJobTitle()));

            printResultMessage(employee.getProjects()
                                        .stream()
                                        .map(Project::getName)
                                        .sorted(String::compareTo)
                                        .collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            printRedMessage(e.getMessage());
        }
    }
}
