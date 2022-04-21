package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name="part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedDto {
    @XmlAttribute(name="name")
    private String name;

    @XmlAttribute(name="price")
    private BigDecimal price;

    @XmlAttribute(name="quantity")
    private int quantity;

    @Size(min = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DecimalMin("0")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Min(0)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
