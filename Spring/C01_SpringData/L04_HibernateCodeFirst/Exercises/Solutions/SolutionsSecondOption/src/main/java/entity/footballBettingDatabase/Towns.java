package entity.footballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Towns extends BaseNameEntity{
    private Countries country;
    private Set<Teams> teams;

    public Towns() {
        this.teams = new HashSet<>();
    }
    @ManyToOne
    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "town")
    public Set<Teams> getTeams() {
        return teams;
    }

    public void setTeams(Set<Teams> teams) {
        this.teams = teams;
    }
}
