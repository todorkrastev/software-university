package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewWithProductsDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "product")
    @XmlElementWrapper(name = "sold-products")
    private List<ProductViewWithBuyerDto> products;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductViewWithBuyerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewWithBuyerDto> products) {
        this.products = products;
    }
}
