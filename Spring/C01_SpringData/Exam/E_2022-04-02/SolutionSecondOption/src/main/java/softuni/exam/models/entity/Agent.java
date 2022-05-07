package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="agents")
public class Agent extends BaseEntity{
    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     * The values are unique in the database.
     */
    @Column(name="first_name", nullable = false, unique = true)
    private String firstName;

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @Column(name="last_name", nullable = false)
    private String lastName;

    /**
     * An email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
     */
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(optional = false)
    private Town town;

    public Agent() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
