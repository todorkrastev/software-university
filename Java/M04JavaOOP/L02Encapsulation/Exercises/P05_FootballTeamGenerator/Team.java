package bg.softuni.java_oop.encapsulation.exercises.P05_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private final List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {
        if (this.players.stream().noneMatch(p -> p.getName().equals(player))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.getName()));
        }
        // this.players.remove(this.players.stream().filter(e -> e.getName().equals(name)).findFirst().orElseThrow());
        this.players.removeIf(p -> p.getName().equals(player));
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
