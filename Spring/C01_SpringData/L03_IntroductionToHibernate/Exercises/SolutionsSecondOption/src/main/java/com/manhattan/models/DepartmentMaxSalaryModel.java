package com.manhattan.models;

import java.math.BigDecimal;

public class DepartmentMaxSalaryModel {
    private String name;
    private BigDecimal salary;

    public DepartmentMaxSalaryModel(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.name, this.salary);
    }
}
