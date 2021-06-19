package bg.softuni.java_advanced.exam_preparation_22_February_2020.P03_Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        this.roster.stream().filter(player -> player.getName().equals(name))
                .findFirst().ifPresent(player -> player.setRank("Member"));
    }

    public void demotePlayer(String name) {
        this.roster.stream().filter(player -> player.getName().equals(name))
                .findFirst().ifPresent(player -> player.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] result = roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);
        setRoster(roster.stream().filter(player -> !player.getClazz().equals(clazz)).collect(Collectors.toList()));
        return result;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Players in the guild: ");
        output.append(getName()).append(":").append(System.lineSeparator());
        getRoster().forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }
}