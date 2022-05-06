package hiberspring.domain.dtos;

import hiberspring.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MessageName(name = "Town")
public class TownSeedDto {
    private String name;
    private Integer population;

    @NotBlank
    public String getName() {
        return name;
    }

    @NotNull
    public Integer getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name;
    }
}
