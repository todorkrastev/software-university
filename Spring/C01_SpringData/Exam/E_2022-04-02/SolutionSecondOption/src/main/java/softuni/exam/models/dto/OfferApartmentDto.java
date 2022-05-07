package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferApartmentDto {
    @XmlElement(name="id")
    private long id;

    @NotNull
    @Positive
    public long getId() {
        return id;
    }
}
