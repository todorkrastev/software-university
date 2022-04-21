package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldDto {

    @XmlAttribute(name="count")
    private int count;

    @XmlElement(name="product")
    private List<ProductDetailsDto> products;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductDetailsDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailsDto> products) {
        this.products = products;
        //this.count = products.size();
    }
}
