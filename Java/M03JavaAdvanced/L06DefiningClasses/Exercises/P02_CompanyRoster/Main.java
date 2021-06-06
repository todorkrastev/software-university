package bg.softuni.java_advanced.defining_classes.exercises.P02_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());

        Map<String, Department> departments = new HashMap<>();

        Employee.setDefaultEmail("n/a");
        Employee.setDefaultAge(-1);

        for (int i = 0; i < num; i++) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            departments.putIfAbsent(department, new Department());

            Employee employee = null;
            String email;
            int age;
            if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);

                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (tokens[4].matches("^\\d+$")) {
                    age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departments.get(department).addEmployee(employee);
        }
        double bestAvgSalary = Integer.MIN_VALUE;
        String bestDepartment = "";

        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if (bestAvgSalary < entry.getValue().getAverageSalary()) {
                bestAvgSalary = entry.getValue().getAverageSalary();
                bestDepartment = entry.getKey();
            }
        }
        Department department = departments.get(bestDepartment);
        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        department.getEmployeeList()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
