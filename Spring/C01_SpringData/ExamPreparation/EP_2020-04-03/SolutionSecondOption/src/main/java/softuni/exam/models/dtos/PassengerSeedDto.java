package softuni.exam.models.dtos;

import softuni.exam.util.MessageName;

import javax.validation.constraints.*;

@MessageName(name="Passenger")
public class PassengerSeedDto {

    private String firstName;

    private String lastName;

    private int age;

    private String phoneNumber;

    private String email;

    private String town;

    /**
     * A char sequence with minimum length 2.
     */
    @Size(min=2)
    public String getFirstName() {
        return firstName;
    }

    /**
     * A char sequence with minimum length 2.
     */
    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    /**
     * A number (must be positive).
     */
    @Positive
    public int getAge() {
        return age;
    }

    /**
     *  A char sequence – phone number.
     */
    @NotNull
    @NotBlank
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * An email – (must contains ‘@’ and ‘.’ – dot).
     * The email of a person is unique.
     */
    @NotNull
    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }

    @NotNull
    @NotEmpty
    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", lastName, email);
    }
}
