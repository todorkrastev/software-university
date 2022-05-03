package softuni.exam.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

public class TicketPassengerDto {
    @XmlElement(name = "email")
    private String email;

    @NotNull
    @NotBlank
    public String getEmail() {
        return email;
    }
}
