package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductsDto {
    @XmlAttribute(name="name")
    private String name;

    @XmlElement(name="products-count")
    private long productCount;

    @XmlElement(name="average-price")
    private double averagePrice;

    @XmlElement(name="total-revenue")
    private BigDecimal totalRevenue;

    public CategoriesByProductsDto(String name, long productCount, double averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.productCount = productCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public CategoriesByProductsDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
