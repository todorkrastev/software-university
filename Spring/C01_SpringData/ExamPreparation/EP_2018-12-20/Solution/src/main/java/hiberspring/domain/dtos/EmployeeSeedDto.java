package hiberspring.domain.dtos;


import hiberspring.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name="Employee")
public class EmployeeSeedDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "position")
    private String position;

    @XmlElement(name = "card")
    private String card;

    @XmlElement(name = "branch")
    private String branch;

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    @NotBlank
    public String getLastName() {
        return lastName;
    }

    @NotBlank
    public String getPosition() {
        return position;
    }

    @NotBlank
    public String getCard() {
        return card;
    }

    @NotBlank
    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
