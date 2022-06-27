package bg.manhattan.battleships.model.entity;

import javax.persistence.*;

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
     * The length of the values should be between 5 and 20 characters long (both numbers are INCLUSIVE)
     */
    @Column(name="full_name", nullable = false, length = 21)
    private String fullName;

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

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
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
