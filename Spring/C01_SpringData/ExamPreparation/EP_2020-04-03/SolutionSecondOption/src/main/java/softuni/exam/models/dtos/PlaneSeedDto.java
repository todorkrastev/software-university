package softuni.exam.models.dtos;

import softuni.exam.util.MessageName;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name = "Plane")
public class PlaneSeedDto {

    @XmlElement(name="register-number")
    private String registerNumber;


    @XmlElement(name="capacity")
    private int capacity;


    @XmlElement(name="airline")
    private String airline;


    /**
     *  A char sequence (minimum length 5).
     *  The register number is unique.
     */
    @NotNull
    @Size(min=5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    /**
     *  Number of passenger (must be positive).
     */
    @Positive
    public int getCapacity() {
        return capacity;
    }

    /**
     *  Name of the airline company with min length of 2.
     */
    @NotBlank
    @Size(min = 2)
    public String getAirline() {
        return airline;
    }

    @Override
    public String toString() {
        return this.getRegisterNumber();
    }
}
