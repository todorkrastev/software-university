package com.spotifyplaylist.session;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class LoggedUser {

    private Long id;
    private String username;

    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLogged() {
        return this.username != null && this.id != null;
    }

    public void invalidate() {
        this.setId(null).setUsername(null);
    }
}
