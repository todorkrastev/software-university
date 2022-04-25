package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="products-stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeList {

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<ProductInRangeXmlDto> products;

    public ProductInRangeList(List<ProductInRangeXmlDto> products) {
        this.products = products;
    }

    public ProductInRangeList() {
    }

    public List<ProductInRangeXmlDto> getProducts() {
        return products;
    }
}
