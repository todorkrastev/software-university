package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "agent")
    private OfferAgentDto agent;

    @XmlElement(name = "apartment")
    private OfferApartmentDto apartment;

    @XmlElement(name = "publishedOn")
    private String publishedOn;

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OfferAgentDto getAgent() {
        return agent;
    }

    public void setAgent(OfferAgentDto agent) {
        this.agent = agent;
    }

    public OfferApartmentDto getApartment() {
        return apartment;
    }

    public void setApartment(OfferApartmentDto apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
