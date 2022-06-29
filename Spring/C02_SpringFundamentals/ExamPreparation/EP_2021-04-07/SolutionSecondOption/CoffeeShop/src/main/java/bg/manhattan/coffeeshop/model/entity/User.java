package bg.manhattan.coffeeshop.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    /**
     * (unique)
     * The length of the username must be between 5 and 20 characters (both numbers are INCLUSIVE).
     */
    @Column(length = 21, nullable = false, unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    /**
     * The length of the last name must be between 5 and 20 characters (both numbers are INCLUSIVE).
     */
    @Column(name = "last_name",nullable = false, length = 21)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Set<Order> orders;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
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
