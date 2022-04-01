package com.manhattan.services.implementations;

import com.manhattan.common.Utilities;
import com.manhattan.entities.Employee;
import com.manhattan.services.interfaces.Service;

import javax.persistence.EntityManager;

import java.io.IOException;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.*;

/**
 * 11.	Find Employees by First Name
 */
public class FindEmployeesByFirstNameServiceImpl extends BaseServiceImpl {

    public FindEmployeesByFirstNameServiceImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void execute() {
        try {
            String pattern = readStringFromConsole("Enter pattern for employee's first name: ");
            printResultMessage(
                    this.entityManager
                            .createQuery(
                                    "SELECT e " +
                                            "FROM Employee e " +
                                            "WHERE LOWER(e.firstName) LIKE :pattern", Employee.class)
                            .setParameter("pattern", pattern.toLowerCase() + "%")
                            .getResultStream()
                            .map(emp -> String.format("%s %s - %s - ($%.2f)",
                                    emp.getFirstName(),
                                    emp.getLastName(),
                                    emp.getJobTitle(),
                                    emp.getSalary()))
                            .collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            printRedMessage(e.getMessage());
        }
    }
}
