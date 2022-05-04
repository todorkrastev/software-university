package softuni.exam.models.dtos;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name="offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name="added-on")
    private String addedOn;

    @XmlElement(name="has-gold-status")
    private Boolean hasGoldStatus;

    @XmlElement(name="car")
    private OfferCarDto car;

    @XmlElement(name = "seller")
    private OfferSellerDto seller;

    @Size(min=5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public OfferCarDto getCar() {
        return car;
    }

    public void setCar(OfferCarDto car) {
        this.car = car;
    }

    public OfferSellerDto getSeller() {
        return seller;
    }

    public void setSeller(OfferSellerDto seller) {
        this.seller = seller;
    }
}
