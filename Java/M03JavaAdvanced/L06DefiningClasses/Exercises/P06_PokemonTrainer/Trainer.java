package bg.softuni.java_advanced.defining_classes.exercises.P06_PokemonTrainer;

import java.util.List;

public class Trainer {
    // Trainer has a name, number of badges and a collection of pokemon
    private final String name;
    // Every Trainer starts with 0 badges.
    private int numOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, int numOfBadges, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numOfBadges = numOfBadges;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return collectionOfPokemon;
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }

    public void setNumOfBadges(int numOfBadges) {
        this.numOfBadges = numOfBadges;
    }

    public void setCollectionOfPokemon(List<Pokemon> collectionOfPokemon) {
        this.collectionOfPokemon = collectionOfPokemon;
    }
}
