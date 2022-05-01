package exam.model.dto;

import exam.util.MessageName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@MessageName(name = "Customer")
public class CustomerSeedDto {

    private String firstName;

    private String lastName;

    private String email;

    private String registeredOn;

    private CustomerTownDto town;

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    /**
     * accepts valid email addresses (must contains '@' and '.' – a dot). The values are unique in the    database.
     */
    @Email
    public String getEmail() {
        return email;
    }

    /**
     * A date when а customer registers in the shop.
     */
    @NotEmpty
    public String getRegisteredOn() {
        return registeredOn;
    }

    public CustomerTownDto getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", this.getFirstName(), this.getLastName(), this.getEmail());
    }
}
