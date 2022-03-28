package exam.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registeredOn;

    private Town town;

    public Customer() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "registered_on", nullable = false)
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    @ManyToOne
    @JoinColumn(name = "town_id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
