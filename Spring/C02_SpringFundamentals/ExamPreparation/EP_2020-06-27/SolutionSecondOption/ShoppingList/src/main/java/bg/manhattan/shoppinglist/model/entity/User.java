package bg.manhattan.shoppinglist.model.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    /**
     * Has an Id – UUID-string or Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username (unique)
     * Length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @Column(nullable = false, unique = true, length = 21)
    private String username;

    /**
     * Password length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @Column(name="password", nullable = false)
    private String passwordHash;

    /**
     * Email
     * Must contains '@'.  Cannot be null.
     */

    @Column(nullable = false)
    private String email;


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

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
