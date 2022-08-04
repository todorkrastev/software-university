package bg.manhattan.heroes.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    /**
     * Length must be between 3 and 20 characters (inclusive 3 and 10).
     */
    @NotNull(message = "Username length must be between 3 and 10 characters.")
    @Size(min=3, max = 10, message = "Username must be between 3 and 20 characters")
    private String username;

    /**
     * The length of the values should be more than 3 characters long (INCLUSIVE)
     */
    @NotNull(message = "Password length must be more than 3 characters.")
    @Size(min=3, message = "Password length must be more than 3 characters.")
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
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
