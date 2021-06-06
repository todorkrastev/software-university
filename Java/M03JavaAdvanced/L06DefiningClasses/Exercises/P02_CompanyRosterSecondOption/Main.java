package bg.softuni.java_advanced.defining_classes.exercises.P02_CompanyRosterSecondOption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int num = Integer.parseInt(reader.readLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String email = "n/a";
            int age = -1;

            String[] input = reader.readLine().trim().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            } else if (input.length == 5) {
                try {
                    age = Integer.parseInt(input[4]);
                } catch (NumberFormatException e) {
                    email = input[4];
                }
            }
            Employee employee = new Employee(name, salary, position, department, email, age);

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department maxAvgSalaryDepartment = departments
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAvgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAvgSalaryDepartment.getName());

        maxAvgSalaryDepartment
                .getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}

