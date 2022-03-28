package softuni.exam.models.dto;

import javax.validation.constraints.Email;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketPassengerDto {

    @XmlElement(name = "email")
    private String email;

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
