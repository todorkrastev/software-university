package softuni.exam.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    private String name;
    private Integer population;
    private String guide;

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "population", nullable = false)
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Column(name = "guide", columnDefinition = "TEXT")
    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
