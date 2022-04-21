package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRootDto {
    @XmlElement(name = "category")
    private Set<CategorySeedDto> categories;

    public CategoryRootDto() {
        this.categories = new HashSet<>();
    }

    public Set<CategorySeedDto> getCategories() {
        return categories;
    }
}
