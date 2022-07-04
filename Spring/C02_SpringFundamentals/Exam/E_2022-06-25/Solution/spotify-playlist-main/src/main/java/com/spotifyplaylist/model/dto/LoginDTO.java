package com.spotifyplaylist.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDTO {

    private Long id;

    @Size(min = 3, max = 20)
    @NotNull
    private String username;

    @Size(min = 3, max = 20)
    @NotNull
    private String password;

    public LoginDTO() {
    }

    public Long getId() {
        return id;
    }

    public LoginDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
