package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="customers")
public class Customer extends BaseEntity {
    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * accepts valid email addresses (must contains '@' and '.' – a dot). The values are unique in the    database.
     */
    @Column(nullable = false)
    private String email;

    /**
     * A date when а customer registers in the shop.
     */
    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;

    @ManyToOne(optional = false)
    private Town town;

    public Customer() {
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

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
