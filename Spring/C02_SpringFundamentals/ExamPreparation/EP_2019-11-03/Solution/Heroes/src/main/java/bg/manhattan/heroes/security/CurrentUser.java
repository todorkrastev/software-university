package bg.manhattan.heroes.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Component
@SessionScope
public class CurrentUser {

    private UUID id;
    private String username;

    public UUID getId() {
        return id;
    }

    public CurrentUser setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean isLoggedIn() {
        return username != null;
    }


    public void clear() {
        id = null;
        username = null;
    }
}
