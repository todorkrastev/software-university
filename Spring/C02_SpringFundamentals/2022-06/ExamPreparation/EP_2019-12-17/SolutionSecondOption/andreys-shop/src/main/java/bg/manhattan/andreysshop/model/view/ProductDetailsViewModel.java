package bg.manhattan.andreysshop.model.view;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDetailsViewModel {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String picture;

    public UUID getId() {
        return id;
    }

    public ProductDetailsViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDetailsViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public ProductDetailsViewModel setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
