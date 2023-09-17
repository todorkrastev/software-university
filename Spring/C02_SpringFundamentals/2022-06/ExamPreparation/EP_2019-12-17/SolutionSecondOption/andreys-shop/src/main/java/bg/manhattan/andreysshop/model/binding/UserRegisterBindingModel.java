package bg.manhattan.andreysshop.model.binding;



import bg.manhattan.andreysshop.model.validator.FieldMatch;
import bg.manhattan.andreysshop.model.validator.UniqueEmail;
import bg.manhattan.andreysshop.model.validator.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Password and Confirm password mut be the same.")
public class UserRegisterBindingModel {

    /**
     * The values should be unique in the database
     */
    @NotNull(message = "Username must be between 3 and 10 characters")
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

    /**
     * The length of the values should be more than 3 characters long (INCLUSIVE)
     */
    @NotNull(message = "Password length must be more than 3 characters.")
    @Size(min=3, message = "Password length must be more than 3 characters.")
    private String password;

    @NotNull(message = "Password length must be more than 3 characters.")
    @Size(min=3, message = "Password length must be more than 3 characters.")
    private String confirmPassword;



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
}
