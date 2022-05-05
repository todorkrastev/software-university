package softuni.exam.domain.dtos;

import softuni.exam.domain.entities.enums.Position;

public class PlayerByTeamListDto {
    private String firstName;
    private String lastName;
    private Position position;
    private Integer number;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("\tPlayer name: %s %s - %s", firstName, lastName, position.toString()))
                .append(System.lineSeparator());
        stringBuilder.append(String.format("\tNumber: %d", number));
        return stringBuilder.toString();
    }
}
