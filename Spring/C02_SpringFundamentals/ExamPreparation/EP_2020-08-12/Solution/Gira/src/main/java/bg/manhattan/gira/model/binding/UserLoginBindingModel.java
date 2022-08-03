package bg.manhattan.gira.model.binding;

import bg.manhattan.gira.model.validator.UniqueEmail;
import bg.manhattan.gira.model.validator.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    /**
     * Email
     * Must contains '@'.  Cannot be null.
     */
    @NotBlank( message = "Email cannot be empty")
    @Email(regexp = "^(\\w+@\\w+)(.\\w+){2,}$", message = "Enter valid email address.")
    private String email;

    /**
     *	Password length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotNull(message = "Password is required.")
    @Size(min=3, max=20, message = "Password length must be between 3 and 20 characters.")
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
