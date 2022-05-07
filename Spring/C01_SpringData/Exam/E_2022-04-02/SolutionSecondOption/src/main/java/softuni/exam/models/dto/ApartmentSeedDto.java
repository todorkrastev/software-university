package softuni.exam.models.dto;

import softuni.exam.util.MessageName;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="apartment")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name="apartment")
public class ApartmentSeedDto {

    @XmlElement(name = "apartmentType")
    private String apartmentType;

    @XmlElement(name = "area")
    private double area;

    @XmlElement(name = "town")
    private String town;

    /**
     * The enumeration, one of the following – two_rooms, three_rooms, four_rooms
     * I have to read enum as string to validate value before convert to enum
     * I've added a record with 'fake_type' at the end of file to prove my validation
     */
    @NotBlank
    @Pattern(regexp = "^(two_rooms|three_rooms|four_rooms)+$")
    public String getApartmentType() {
        return apartmentType;
    }

    /**
     * Accepts number values that are more than or equal to 40.00.
     */
    @NotNull
    @DecimalMin(value = "40.00")
    public double getArea() {
        return area;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", apartmentType, area);
    }
}
