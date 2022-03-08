package entity.footballBettingDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Countries {
    private String id;
    private String name;
    private Set<Continents> continents;
    private Set<Towns> towns;

    public Countries() {
        this.continents = new HashSet<>();
        this.towns = new HashSet<>();
    }
@Id
@Column(nullable = false, unique = true, length = 3)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
@Column(nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@ManyToMany(mappedBy = "countries")
    public Set<Continents> getContinents() {
        return continents;
    }

    public void setContinents(Set<Continents> continents) {
        this.continents = continents;
    }

    @OneToMany(mappedBy = "country")
    public Set<Towns> getTowns() {
        return towns;
    }

    public void setTowns(Set<Towns> towns) {
        this.towns = towns;
    }
}
