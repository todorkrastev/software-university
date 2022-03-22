package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewSoldDto {

    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "product")
    private List<ProductViewDetailsDto> products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductViewDetailsDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewDetailsDto> products) {
        this.products = products;
        this.count = products.size();
    }
}
