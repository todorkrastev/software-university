package softuni.exam.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {
    /**
     * A combination from letters and numbers with minimum length of 2 .
     * The serial numbers are unique.
     */
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    /**
     * A price of the ticket. Must be positive.
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * A date and time of plane taking off.
     */
    @Column(name="take_off", nullable = false)
    private LocalDateTime takeoff;

    @ManyToOne
    private Town fromTown;

    @ManyToOne
    private Town toTown;

    @ManyToOne(optional = false)
    private Passenger passenger;

    @ManyToOne(optional = false)
    private Plane plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(LocalDateTime takeoff) {
        this.takeoff = takeoff;
    }

    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }

    public softuni.exam.models.entities.Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(softuni.exam.models.entities.Passenger passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
