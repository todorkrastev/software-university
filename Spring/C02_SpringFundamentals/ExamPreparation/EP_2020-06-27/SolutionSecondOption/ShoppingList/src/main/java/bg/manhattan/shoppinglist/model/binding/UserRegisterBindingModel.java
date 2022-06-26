package bg.manhattan.shoppinglist.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    /**
     * Username (unique)
     * Length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotNull(message = "Username must be between 3 and 20 characters")
    @Size(min=3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    /**
     * Email
     * Must contains '@'.  Cannot be null.
     */
    @NotNull( message = "Email cannot be empty")
    @Email(regexp = "^(\\w+@\\w+)(.\\w+){2,}$", message = "Email cannot be empty")
    private String email;

    /**
     * Password length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotNull(message = "Password length must be between 3 and 20 characters")
    @Size(min=3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;

    @NotNull
    @Size(min=3, max = 20)
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
