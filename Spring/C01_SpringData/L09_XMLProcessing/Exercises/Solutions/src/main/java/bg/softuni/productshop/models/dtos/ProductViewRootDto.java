package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewRootDto {

    @XmlElement(name = "product")
    private List<ProductViewWithSellerDto> products;

    public List<ProductViewWithSellerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewWithSellerDto> products) {
        this.products = products;
    }
}
