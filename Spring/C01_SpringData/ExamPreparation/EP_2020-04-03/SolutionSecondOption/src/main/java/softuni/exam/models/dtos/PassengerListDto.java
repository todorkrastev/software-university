package softuni.exam.models.dtos;

public class PassengerListDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer numberOfTickets;

    public PassengerListDto(String firstName, String lastName, String email, String phoneNumber, int numberOfTickets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.numberOfTickets = numberOfTickets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setTicketsSize(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Passenger %s %s", firstName, lastName)).append(System.lineSeparator());
        builder.append(String.format("\tEmail - %s", email)).append(System.lineSeparator());
        builder.append(String.format("\tPhone - %s", phoneNumber)).append(System.lineSeparator());
        builder.append(String.format("\tNumber of tickets - %d", numberOfTickets)).append(System.lineSeparator());
        return builder.toString();
    }
}
