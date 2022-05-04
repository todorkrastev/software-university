package softuni.exam.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars", uniqueConstraints = {@UniqueConstraint(columnNames = {"make", "model", "kilometers"})})
public class Car extends BaseEntity {

    @Column(length = 19)
    private String make; // – a char sequence (between 2 to 20 exclusive).

    @Column(length = 19)
    private String model; // – a char sequence (between 2 to 20 exclusive).

    @Column(nullable = false)
    private Integer kilometers; // – a number (must be positive).

    @Column(name = "registered_on")
    private LocalDate registeredOn; // – a date.

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "car")
    private Set<Picture> pictures;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "car")
    private Set<Offer> offerSet;

    public Car() {
        pictures = new HashSet<>();
        offerSet = new HashSet<>();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
