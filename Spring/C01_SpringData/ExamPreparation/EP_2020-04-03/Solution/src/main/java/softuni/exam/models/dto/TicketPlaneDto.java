package softuni.exam.models.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketPlaneDto {

    @XmlElement(name = "register-number")
    private String registerNumber;

    @Size(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerName) {
        this.registerNumber = registerName;
    }
}
