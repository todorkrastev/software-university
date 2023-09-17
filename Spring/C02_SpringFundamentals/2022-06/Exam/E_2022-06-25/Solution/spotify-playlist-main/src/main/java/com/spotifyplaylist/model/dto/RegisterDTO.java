package com.spotifyplaylist.model.dto;

import com.spotifyplaylist.vallidation.annotation.UniqueEmail;
import com.spotifyplaylist.vallidation.annotation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterDTO {

    private Long id;

    @UniqueUsername
    @Size(min = 3, max = 20)
    @NotNull
    private String username;

    @UniqueEmail
    @Email
    @NotBlank
    private String email;

    @Size(min = 3, max = 20)
    @NotNull
    private String password;

    @Size(min = 3, max = 20)
    @NotNull
    private String confirmPassword;

    public RegisterDTO() {
    }

    public Long getId() {
        return id;
    }

    public RegisterDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
