package com.todorkrastev.andreysstore.model.entity;

import com.todorkrastev.andreysstore.model.entity.enums.CategoryName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private CategoryName categoryName;
    private String description;

    public Category() {
    }

    public Category(CategoryName categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @Enumerated
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
