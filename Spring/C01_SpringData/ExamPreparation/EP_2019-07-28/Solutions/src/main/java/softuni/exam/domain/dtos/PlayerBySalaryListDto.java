package softuni.exam.domain.dtos;

import softuni.exam.domain.entities.enums.Position;

import java.math.BigDecimal;

public class PlayerBySalaryListDto {
    private String firstName;
    private String lastName;
    private Integer number;
    private BigDecimal salary;
    private String teamName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Player name: %s %s", firstName, lastName )).append(System.lineSeparator());
        stringBuilder.append(String.format("\tNumber: %d", number )).append(System.lineSeparator());
        stringBuilder.append(String.format("\tSalary: %.2f", salary )).append(System.lineSeparator());
        stringBuilder.append(String.format("\tTeam: %s", teamName));
        return stringBuilder.toString();
    }
}
