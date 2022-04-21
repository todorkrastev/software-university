package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAndSoldProductsDto {

    @XmlAttribute(name="first-name")
    private String firstName;

    @XmlAttribute(name="last-name")
    private String lastName;

    @XmlAttribute(name="age")
    private int age;

    @XmlElement(name="sold-products")
    private ProductSoldDto soldProducts;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProductSoldDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
