package entity.footballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "continents")
public class Continents extends BaseNameEntity {
    private Set<Countries> countries;

    public Continents() {
        this.countries = new HashSet<>();
    }
    @ManyToMany
    public Set<Countries> getCountries() {
        return countries;
    }

    public void setCountries(Set<Countries> countries) {
        this.countries = countries;
    }
}
