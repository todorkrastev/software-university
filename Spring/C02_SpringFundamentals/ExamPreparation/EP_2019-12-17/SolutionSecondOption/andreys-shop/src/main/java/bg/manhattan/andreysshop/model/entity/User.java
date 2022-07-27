package bg.manhattan.andreysshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseEntity{

    /**
     * The length of the values should be between 3 and 10 characters long (both numbers are INCLUSIVE)
     * The values should be unique in the database
     */
    @Column(nullable = false, length = 11, unique = true)
    private String username;

    /**
     * The length of the values should be more than 3 characters long (INCLUSIVE)
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
