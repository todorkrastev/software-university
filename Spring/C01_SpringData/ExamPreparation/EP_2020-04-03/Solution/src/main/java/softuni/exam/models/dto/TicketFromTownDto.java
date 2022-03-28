package softuni.exam.models.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketFromTownDto {

    @XmlElement(name = "name")
    private String name;

    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
