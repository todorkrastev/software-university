package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    private String serialNumber;
    private BigDecimal price;
    private LocalDateTime takeoff;

    private Passenger passenger;
    private Plane plane;
    private Town fromTown;
    private Town toTown;


    @Column(name = "serial_number", unique = true)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column(name = "price", precision = 19, scale = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "take_off")
    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(LocalDateTime takeoff) {
        this.takeoff = takeoff;
    }

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @ManyToOne
    @JoinColumn(name = "plane_id")
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @ManyToOne
    @JoinColumn(name = "from_town_id")
    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    @ManyToOne
    @JoinColumn(name = "to_town_id")
    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }
}
