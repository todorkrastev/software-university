package hiberspring.domain.dtos;

public class EmployeeListViewModel {
    private String firstName;
    private String lastName;
    private String position;
    private String cardNumber;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s %s", firstName, lastName)).append(System.lineSeparator());
        builder.append(String.format("Position: %s", position)).append(System.lineSeparator());
        builder.append(String.format("Card Number: %s", cardNumber)).append(System.lineSeparator());
        builder.append("-------------------------");
        return builder.toString();
    }
}
