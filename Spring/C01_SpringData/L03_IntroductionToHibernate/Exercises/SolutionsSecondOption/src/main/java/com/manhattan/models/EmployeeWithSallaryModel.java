package com.manhattan.models;

import java.math.BigDecimal;

public class EmployeeWithSallaryModel {
    private String firstName;
    private String lastName;
    private String departmentName;
    private BigDecimal salary;

    public EmployeeWithSallaryModel(String firstName, String lastName, String departmentName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s from %s - $%.2f",
                this.firstName, this.lastName, this.departmentName, this.salary);
    }
}
