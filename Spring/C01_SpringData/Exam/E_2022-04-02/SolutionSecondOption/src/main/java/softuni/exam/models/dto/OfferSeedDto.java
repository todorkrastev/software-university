package softuni.exam.models.dto;

import softuni.exam.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name="offer")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name = "offer")
public class OfferSeedDto {

    @XmlElement(name="price")
    private BigDecimal price;

    @XmlElement(name="publishedOn")
    private String publishedOn;

    @XmlElement(name="agent")
    private OfferAgentDto agent;

    @XmlElement(name="apartment")
    private OfferApartmentDto apartment;

    /**
     * Accepts a positive number.
     */
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * A date in the "dd/MM/yyyy" format.
     */
    @NotBlank
    @Pattern(regexp = "^\\d{2}\\/\\d{2}\\/\\d{4}$")
    public String getPublishedOn() {
        return publishedOn;
    }

    @NotNull
    public OfferAgentDto getAgent() {
        return agent;
    }

    @NotNull
    public OfferApartmentDto getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return String.format("%.2f", price);
    }
}
