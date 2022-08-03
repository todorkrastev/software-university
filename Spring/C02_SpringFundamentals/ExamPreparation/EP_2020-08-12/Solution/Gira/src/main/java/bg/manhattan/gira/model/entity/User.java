package bg.manhattan.gira.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseEntity{

    /**
     * Username length must be between 3 and 20 characters (inclusive 3 and 20).
     * The values should be unique in the database
     */
    @Column(nullable = false, length = 21)
    private String username;

    /**
     * Password length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @Column(name="password", nullable = false)
    private String passwordHash;

    /**
     * The values should contain a '@' symbol
     * The values should be unique in the database
     */
    @Column(nullable = false, unique = true)
    private String email;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public User setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
