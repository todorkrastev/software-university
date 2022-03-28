package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownSeedDto {

    @Expose
    private String name;

    @Expose
    private Integer population;

    @Expose
    private String guide;

    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @NotBlank
    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
