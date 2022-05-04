package softuni.exam.models.dtos;

import softuni.exam.models.entities.enums.Rating;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedDto {
    @XmlElement(name="first-name")
    private String firstName;

    @XmlElement(name="last-name")
    private String lastName;

    @XmlElement(name="email")
    private String email;

    @XmlElement(name="rating")
    private Rating rating;

    @XmlElement(name="town")
    private String town;

    @Size(min=2, max = 19)
    public String getFirstName() {
        return firstName;
    }

    public SellerSeedDto() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min=2, max = 19)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
