package bg.softuni.java_advanced.defining_classes.exercises.P02_CompanyRosterSecondOption;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getAvgSalary() {
        return this.employees
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public String getName() {
        return this.name;
    }
}
