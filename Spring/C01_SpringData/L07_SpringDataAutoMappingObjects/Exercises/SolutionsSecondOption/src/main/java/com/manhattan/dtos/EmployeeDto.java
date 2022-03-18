package com.manhattan.dtos;

import java.math.BigDecimal;

public class EmployeeDto extends BaseEmployeeDto {
    private BigDecimal salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), salary);
    }
}
