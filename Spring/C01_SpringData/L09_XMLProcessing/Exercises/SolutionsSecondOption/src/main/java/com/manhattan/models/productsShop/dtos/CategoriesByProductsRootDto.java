package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesByProductsRootDto {

    @XmlElement(name = "category")
    private List<CategoriesByProductsDto> categories;

    public CategoriesByProductsRootDto(List<CategoriesByProductsDto> categories) {
        this.categories = categories;
    }

    public CategoriesByProductsRootDto() {
    }
}
