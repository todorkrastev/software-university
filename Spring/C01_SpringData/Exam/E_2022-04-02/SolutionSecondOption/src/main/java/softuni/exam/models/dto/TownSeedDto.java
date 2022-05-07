package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@MessageName(name = "town")
public class TownSeedDto {
    @Expose
    private String townName;

    @Expose
    private int population;

    /**
     * Accepts char sequences as values where their character
     * length value is higher than or equal to 2.
     * The values are unique in the database.
     */
    @NotBlank
    @Size(min = 2)
    public String getTownName() {
        return townName;
    }

    /**
     * Accepts number values (must be positive), 0 as a value is exclusive.
     */
    @NotNull
    @Positive
    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", townName, population);
    }
}
