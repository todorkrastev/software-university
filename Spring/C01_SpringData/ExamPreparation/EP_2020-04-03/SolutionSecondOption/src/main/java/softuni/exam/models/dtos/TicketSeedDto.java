package softuni.exam.models.dtos;

import softuni.exam.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name="ticket")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name="Ticket")
public class TicketSeedDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeoff;

    @XmlElement(name = "from-town")
    private TicketTownDto fromTown;

    @XmlElement(name = "to-town")
    private TicketTownDto toTown;

    @XmlElement(name = "passenger")
    private TicketPassengerDto passenger;

    @XmlElement(name = "plane")
    private TicketPlaneDto plane;

    /**
     * A combination from letters and numbers with minimum length of 2 .
     * The serial numbers are unique.
     */
    @Size(min=2)
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * A price of the ticket. Must be positive.
     */
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * A date and time of plane taking off.
     */
    @NotNull
    @NotBlank
    public String getTakeoff() {
        return takeoff;
    }

    @NotNull
    public TicketTownDto getFromTown() {
        return fromTown;
    }

    @NotNull
    public TicketTownDto getToTown() {
        return toTown;
    }

    @NotNull
    public TicketPassengerDto getPassenger() {
        return passenger;
    }

    @NotNull
    public TicketPlaneDto getPlane() {
        return plane;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", fromTown.getName(), toTown.getName());
    }
}
