package entity.footballBettingDatabase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Teams extends BaseNameEntity {
    private byte[] logo;
    private String initials;
    private Colors primaryKitColor;
    private Colors secondaryKitColor;
    private Towns town;
    private BigDecimal budget;
    private Set<Games> homeTeamGames;
    private Set<Games> awayTeamGames;
    private Set<Players> players;

    public Teams() {
        this.homeTeamGames = new HashSet<>();
        this.awayTeamGames = new HashSet<>();
    }

    @Column(name = "logo")
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Column(nullable = false, length = 3)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @OneToOne()
    @JoinColumn(name = "primary_set_color")
    public Colors getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Colors primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @OneToOne
    @JoinColumn(name = "secondary_set_color")
    public Colors getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Colors secondlyKitColor) {
        this.secondaryKitColor = secondlyKitColor;
    }

    @ManyToOne
    public Towns getTown() {
        return town;
    }

    public void setTown(Towns town) {
        this.town = town;
    }

    @Column
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "homeTeam")
    public Set<Games> getHomeTeamGames() {
        return homeTeamGames;
    }

    public void setHomeTeamGames(Set<Games> homeTeamGames) {
        this.homeTeamGames = homeTeamGames;
    }

    @OneToMany(mappedBy = "awayTeam")
    public Set<Games> getAwayTeamGames() {
        return awayTeamGames;
    }

    public void setAwayTeamGames(Set<Games> awayTeamGames) {
        this.awayTeamGames = awayTeamGames;
    }

    @OneToMany(mappedBy = "team")
    public Set<Players> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Players> players) {
        this.players = players;
    }
}
