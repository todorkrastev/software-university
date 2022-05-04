package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedRootDto {

    @XmlElement(name="seller")
    private List<SellerSeedDto> sellers;

    public List<SellerSeedDto> getSellers() {
        return sellers;
    }

    public SellerSeedRootDto() {
        this.sellers = new ArrayList<>();
    }
}
