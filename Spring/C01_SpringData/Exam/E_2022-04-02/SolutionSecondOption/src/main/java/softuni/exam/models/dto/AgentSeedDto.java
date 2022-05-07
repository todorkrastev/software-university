package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.util.MessageName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MessageName(name="agent")
public class AgentSeedDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;


    @Expose
    private String email;

    @Expose
    private String town;

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     * The values are unique in the database.
     */
    @NotBlank
    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @NotBlank
    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    /**
     * An email – (must contains ‘@’ and ‘.’ – dot).
     * The email of a seller is unique.
     */
    @NotNull
    @Email
    public String getEmail() {
        return email;
    }


    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
