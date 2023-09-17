package bg.manhattan.gira.model.service;

public class UserServiceLoginModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public UserServiceLoginModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceLoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
