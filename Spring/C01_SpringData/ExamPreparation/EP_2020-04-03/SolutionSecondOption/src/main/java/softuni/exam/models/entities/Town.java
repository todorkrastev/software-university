package softuni.exam.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="towns")
public class Town extends BaseEntity{
    /**
     * A char sequence with minimum length 2.
     * The name is unique.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * А number (must be positive).
     */
    @Column(nullable = false)
    private Integer population;

    /**
     * Long and detailed description of all known places
     */
    @Column(columnDefinition = "TEXT")
    private String guide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
