package softuni.exam.models.dtos;

import softuni.exam.util.MessageName;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@MessageName(name="Town")
public class TownSeedDto {

    private String name;

    private Integer population;

    private String guide;

    /**
     * A char sequence with minimum length 2.
     * The name is unique.
     */
    @Size(min = 2)
    public String getName() {
        return name;
    }


    /**
     * А number (must be positive).
     */
    @Positive
    public Integer getPopulation() {
        return population;
    }

    /**
     * Long and detailed description of all known places
     */
    public String getGuide() {
        return guide;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, population);
    }
}
