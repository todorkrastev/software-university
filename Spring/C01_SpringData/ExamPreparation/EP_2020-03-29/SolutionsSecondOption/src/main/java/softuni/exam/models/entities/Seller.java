package softuni.exam.models.entities;

import softuni.exam.models.entities.enums.Rating;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity {
    @Column(length = 19)
    private String firstName; // a char sequence (between 2 to 20 exclusive).

    @Column(length = 19)
    private String lastName; // a char sequence (between 2 to 20 exclusive).

    @Column(nullable = false, unique = true)
    private String email; // an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rating rating; // enumerated value must be one of these GOOD, BAD or UNKNOWN. Cannot be null.

    @Column(nullable = false)
    private String town; // a char sequence – the name of a town. Cannot be null.

    public Seller() {
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

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
