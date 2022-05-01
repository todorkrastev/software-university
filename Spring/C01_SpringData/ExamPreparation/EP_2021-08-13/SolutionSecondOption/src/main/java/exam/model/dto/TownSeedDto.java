package exam.model.dto;

import exam.util.MessageName;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name = "Town")
public class TownSeedDto {

    @XmlElement(name = "name")
    private String name;


    @XmlElement(name = "population")
    private int population;


    @XmlElement(name = "travel-guide")
    private String travelGuide;

    public TownSeedDto() {
    }

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 2.
     */
    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * accepts number values (must be positive), 0 as a value is exclusive.
     */
    @Positive
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * a long and detailed description of all known places with a character length value
     * higher than or equal to 10.
     */
    @Size(min = 10)
    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }

    @Override
    public String toString() {
        return name;
    }
}
