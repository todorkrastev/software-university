package bg.manhattan.heroes.model.binding;



import bg.manhattan.heroes.model.validator.FieldMatch;
import bg.manhattan.heroes.model.validator.UniqueEmail;
import bg.manhattan.heroes.model.validator.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Password and Confirm password must be the same.")
public class UserRegisterBindingModel {

    @NotBlank(message = "Username is required")
    @UniqueUserName(message = "Username must be unique.")
    private String username;

    /**
     * Email
     * Must contains '@'.  Cannot be null.
     */
    @NotNull( message = "Enter valid email address")
    @Email(regexp = "^(\\w+@\\w+)(.\\w+){2,}$", message = "Enter valid email address")
    @UniqueEmail(message="Email must be unique.")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

    @NotBlank(message = "Country is required")
    private String country;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
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

    public String getCountry() {
        return country;
    }

    public UserRegisterBindingModel setCountry(String country) {
        this.country = country;
        return this;
    }
}
