package bg.manhattan.musicdb.model.binding;

import bg.manhattan.musicdb.model.validator.FieldMatch;
import bg.manhattan.musicdb.model.validator.UniqueEmail;
import bg.manhattan.musicdb.model.validator.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Password and Confirm password mut be the same.")
public class UserRegisterBindingModel {

    /**
     * Username length must be between 3 and 20 characters (inclusive 3 and 20).
     * The values should be unique in the database
     */
    @NotNull(message = "Username must be between 3 and 20 characters")
    @Size(min=3, max = 20, message = "Username must be between 3 and 20 characters")
    @UniqueUserName(message = "Username must be unique.")
    private String username;

    /**
     * Full Name length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotNull(message = "Full name must be between 3 and 20 characters")
    @Size(min=3, max = 20, message = "Full name must be between 3 and 20 characters")
    private String fullName;

    /**
     * Email
     * Must contains '@'.  Cannot be null.
     */
    @NotNull( message = "Email is required")
    @Email(regexp = "^(\\w+@\\w+)(.\\w+){2,}$", message = "Must be valid email")
    @UniqueEmail(message="Email must be unique.")
    private String email;

    /**
     * 	Password length must be between 5 and 20 characters (inclusive 5 and 20).
     */
    @NotNull(message = "Password is required")
    @Size(min=5, max = 20, message = "Password length must be between 5 and 20 characters.")
    private String password;

    @NotNull(message = "Confirm password is required")
    @Size(min=5, max = 20, message = "Confirm password length must be between 5 and 20 characters.")
    private String confirmPassword;



    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
