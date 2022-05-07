package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    /**
     *  Accepts char sequences as values where their character length value is higher than or equal
     *     to 2. The values are unique in the database.
     */
    @Column(name="town_name", nullable = false, unique = true)
    private String townName;

    /**
     * Accepts number values (must be positive), 0 as a value is exclusive.
     */
    @Column(nullable = false)
    private int population;

    public Town() {
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
