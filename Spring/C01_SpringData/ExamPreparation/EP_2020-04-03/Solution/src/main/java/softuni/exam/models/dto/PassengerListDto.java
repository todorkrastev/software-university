package softuni.exam.models.dto;

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
        return String.format("Passenger %s %s\n" +
                        "\tEmail - %s\n" +
                        "\tPhone - %s\n" +
                        "\tNumber of tickets - %d",
                this.getFirstName(),
                this.getLastName(),
                this.getEmail(),
                this.getPhoneNumber(),
                this.getNumberOfTickets()) +
                System.lineSeparator();
    }
}
