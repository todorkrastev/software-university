package softuni.exam.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeOff;

    @XmlElement(name = "from-town")
    private TicketFromTownDto fromTown;

    @XmlElement(name = "to-town")
    private TicketToTownDto toTown;

    @XmlElement(name = "passenger")
    private TicketPassengerDto passenger;

    @XmlElement(name = "plane")
    private TicketPlaneDto plane;

    @Size(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotBlank
    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public TicketFromTownDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TicketFromTownDto fromTown) {
        this.fromTown = fromTown;
    }

    public TicketToTownDto getToTown() {
        return toTown;
    }

    public void setToTown(TicketToTownDto toTown) {
        this.toTown = toTown;
    }

    public TicketPassengerDto getPassenger() {
        return passenger;
    }

    public void setPassenger(TicketPassengerDto passenger) {
        this.passenger = passenger;
    }

    public TicketPlaneDto getPlane() {
        return plane;
    }

    public void setPlane(TicketPlaneDto plane) {
        this.plane = plane;
    }
}
