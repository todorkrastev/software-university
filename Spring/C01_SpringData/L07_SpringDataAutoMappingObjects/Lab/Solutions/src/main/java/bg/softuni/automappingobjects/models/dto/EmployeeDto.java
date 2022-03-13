package bg.softuni.automappingobjects.models.dto;

import java.math.BigDecimal;

public class EmployeeDto extends BasicEmployeeDto {

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
