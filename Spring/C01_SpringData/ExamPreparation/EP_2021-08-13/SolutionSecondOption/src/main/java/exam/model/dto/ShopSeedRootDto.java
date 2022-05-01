package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedRootDto {

    @XmlElement(name="shop")
    private final List<ShopSeedDto> shops;

    public ShopSeedRootDto() {
        this.shops = new ArrayList<>();
    }

    public List<ShopSeedDto> getShops() {
        return shops;
    }
}
