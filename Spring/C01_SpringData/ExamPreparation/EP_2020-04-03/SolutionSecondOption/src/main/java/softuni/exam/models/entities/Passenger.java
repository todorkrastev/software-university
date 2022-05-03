package softuni.exam.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="passenger")
public class Passenger extends BaseEntity {

    /**
     * A char sequence with minimum length 2.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * A char sequence with minimum length 2.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * A number (must be positive).
     */
    @Column(nullable = false)
    private int age;

    /**
     *  A char sequence – phone number.
     */
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    /**
     * An email – (must contains ‘@’ and ‘.’ – dot).
     * The email of a person is unique.
     */
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(optional = false)
    private Town town;

    @OneToMany(mappedBy = "passenger", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    public Passenger() {
        this.tickets = new HashSet<>();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
