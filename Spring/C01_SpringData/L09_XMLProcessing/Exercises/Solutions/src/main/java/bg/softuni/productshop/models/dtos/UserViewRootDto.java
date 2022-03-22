package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    private List<UserViewWithProductsDto> products;

    public List<UserViewWithProductsDto> getProducts() {
        return products;
    }

    public void setProducts(List<UserViewWithProductsDto> products) {
        this.products = products;
    }
}
