package com.todorkrastev.andreysstore.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private BigDecimal budget;

    public UserRegisterBindingModel() {
    }

    @Length(min = 2, message = "Username length must at least 2 characters long!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Email(message = "Email must contain '@'!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 2, message = "Password length must be at least 2 characters long!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @DecimalMin("0")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
