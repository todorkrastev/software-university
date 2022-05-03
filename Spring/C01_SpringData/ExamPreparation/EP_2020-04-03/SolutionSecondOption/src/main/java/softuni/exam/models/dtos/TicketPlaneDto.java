package softuni.exam.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

public class TicketPlaneDto {
    @XmlElement(name="register-number")
    private String registerNumber;

    @NotNull
    @NotBlank
    public String getRegisterNumber() {
        return registerNumber;
    }
}
