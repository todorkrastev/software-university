package exam.model.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CustomerSeedDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String email;

    @Expose
    private String registeredOn;

    @Expose
    private CustomerTownDto town;

    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2)
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

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public CustomerTownDto getTown() {
        return town;
    }

    public void setTown(CustomerTownDto town) {
        this.town = town;
    }
}
