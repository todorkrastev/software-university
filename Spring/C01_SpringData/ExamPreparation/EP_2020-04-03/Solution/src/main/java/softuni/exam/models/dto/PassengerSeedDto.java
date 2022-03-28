package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PassengerSeedDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private String phoneNumber;

    @Expose
    private String email;

    @Expose
    private String town;


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

    @Positive
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotBlank
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Email
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
