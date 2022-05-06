package hiberspring.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedRootDto {
    @XmlElement(name="product")
    private final List<ProductSeedDto> products;

    public ProductSeedRootDto() {
        this.products = new ArrayList<>();
    }

    public List<ProductSeedDto> getProducts() {
        return products;
    }
}
