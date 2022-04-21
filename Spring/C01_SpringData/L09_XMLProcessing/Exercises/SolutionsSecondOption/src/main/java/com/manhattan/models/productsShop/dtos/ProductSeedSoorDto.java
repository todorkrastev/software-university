package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedSoorDto {

    @XmlElement(name="product")
    Set<ProductSeedDto> products;

    public ProductSeedSoorDto() {
        this.products = new HashSet<>();
    }

    public Set<ProductSeedDto> getProducts() {
        return products;
    }

}
