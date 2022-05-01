package softuni.exam.instagraphlite.models.dtos;

import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.util.MessageName;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MessageName(name = "User")
public class UserSeedDto {

    private String username;

    private String password;

    private String profilePicture;


    /**
     * A char sequence. Cannot be null. The username is unique.
     * Must be between 2 and 18 (both numbers are INCLUSIVE)
     */
    @Size(min = 2, max = 18)
    @NotBlank
    public String getUsername() {
        return username;
    }

    /**
     * A char sequence. Cannot be null.
     * Must be at least 4 characters long, inclusive.
     */
    @Size(min = 4)
    @NotBlank
    public String getPassword() {
        return password;
    }

    /**
     * A Picture. Cannot be null.
     */
    @NotBlank
    public String getProfilePicture() {
        return profilePicture;
    }

    @Override
    public String toString() {
        return String.format(": %s", username);
    }
}
