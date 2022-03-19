package bg.softuni.productshop.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class CategorySeedDto {
    @Expose
    private String name;

    public CategorySeedDto() {
    }

    @Size(min = 3, max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
