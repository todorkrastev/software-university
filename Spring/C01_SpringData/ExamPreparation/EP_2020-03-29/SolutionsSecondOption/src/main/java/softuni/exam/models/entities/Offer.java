package softuni.exam.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "offers", uniqueConstraints = {@UniqueConstraint(columnNames = {"description", "addedOn"})})
public class Offer extends BaseEntity {
    @Column
    private BigDecimal price; // a number (must be positive number).

    @Column(columnDefinition = "TEXT")
    private String description; // a very long text with minimum length 5.

    @Column(nullable = false, name = "has_gold_status")
    private Boolean hasGoldStatus; //  can be true or false.

    @Column
    private LocalDateTime addedOn; // date and time of adding the offer.
    //The combination of description and addedOn makes an offer unique.

    @ManyToOne
    private Car car;

    @ManyToOne
    private Seller seller;

    @ManyToMany
    private Set<Picture> pictures;

    public Offer() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
