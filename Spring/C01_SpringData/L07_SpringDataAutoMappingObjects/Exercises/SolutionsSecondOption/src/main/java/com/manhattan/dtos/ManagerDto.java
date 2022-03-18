package com.manhattan.dtos;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDto extends BaseEmployeeDto {
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return String.format("%s | Employees %d%s", super.toString(),
                subordinates.size(),
                (subordinates.isEmpty() ? "" : System.lineSeparator() +
                        subordinates
                                .stream()
                                .map(e -> String.format("    - %s", e.toString()))
                                .collect(Collectors.joining(System.lineSeparator()))));
    }
}
