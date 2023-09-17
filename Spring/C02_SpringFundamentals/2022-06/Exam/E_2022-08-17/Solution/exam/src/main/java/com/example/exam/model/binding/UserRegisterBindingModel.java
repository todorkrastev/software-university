package com.example.exam.model.binding;

import com.example.exam.model.validator.FieldMatch;
import com.example.exam.model.validator.UniqueEmail;
import com.example.exam.model.validator.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(first = "password", second = "confirmPassword", message = "Password and Confirm password must be the same!")
public class UserRegisterBindingModel {

    @NotNull(message = "Username length must be between 3 and 20 characters!")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @UniqueUserName(message = "Username must be unique.")
    private String username;


    @NotNull(message = "Email cannot be empty")
    @Email(regexp = "^(\\w+@\\w+)(.\\w+){2,}$", message = "Enter valid email address")
    @UniqueEmail(message = "Email must be unique.")
    private String email;


    @NotNull(message = "Password length must be between 3 and 20 characters!")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotNull(message = "Confirm password length must be between 3 and 20 characters!")
    @Size(min = 3, max = 20, message = "Confirm password length must be between 3 and 20 characters!")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
}
