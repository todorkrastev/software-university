package bg.manhattan.shoppinglist.model.view;

import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class ShoppingItemViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryNameEnum categoryName;

    public ShoppingItemViewModel(Long id, String name, BigDecimal price, CategoryNameEnum categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public ShoppingItemViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShoppingItemViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ShoppingItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategoryName() {
        return categoryName;
    }

    public ShoppingItemViewModel setCategoryName(CategoryNameEnum categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}
