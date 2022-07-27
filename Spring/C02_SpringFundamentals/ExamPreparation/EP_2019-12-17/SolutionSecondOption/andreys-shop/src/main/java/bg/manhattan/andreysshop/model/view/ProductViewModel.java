package bg.manhattan.andreysshop.model.view;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductViewModel {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String picture;

    public UUID getId() {
        return id;
    }

    public ProductViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public ProductViewModel setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
