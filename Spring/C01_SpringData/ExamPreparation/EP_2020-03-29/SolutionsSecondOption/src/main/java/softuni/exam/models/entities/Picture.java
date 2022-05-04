package softuni.exam.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="pictures")
public class Picture extends BaseEntity {
    @Column(length = 20, unique = true)
    private String name; // a char sequence (between 2 to 20 exclusive). The name of a picture is unique.

    @Column(name = "data_and_time")
    private LocalDateTime dateAndTime; // The date and time of a picture.

    @ManyToOne
    private Car car;

    @ManyToMany(mappedBy = "pictures")
    private Set<Offer> offers;

    public Picture() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
