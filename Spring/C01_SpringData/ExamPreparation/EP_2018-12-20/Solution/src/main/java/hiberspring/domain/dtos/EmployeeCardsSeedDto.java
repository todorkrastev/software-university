package hiberspring.domain.dtos;

import hiberspring.util.MessageName;

import javax.validation.constraints.NotBlank;

@MessageName(name="EmployeeCards")
public class EmployeeCardsSeedDto {

    private String number;

    @NotBlank
    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
