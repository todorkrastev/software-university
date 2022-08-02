package bg.manhattan.musicdb.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    /**
     * Length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotBlank(message = "Username is required")
    @Size(min=3, max = 20, message = "Length must between 3 and 20 characters")
    private String username;

    /**
     * 	Password length must be between 5 and 20 characters (inclusive 5 and 20).
     */
    @NotBlank(message = "Password is required.")
    @Size(min=5, max = 20, message = "Length must between 5 and 20 characters")
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
