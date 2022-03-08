package entity.footballBettingDatabase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Rounds extends BaseNameEntity {

    private Set<Games> games;

    public Rounds() {
        this.games = new HashSet<>();
    }

    @OneToMany(mappedBy = "roundId")
    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }
}
