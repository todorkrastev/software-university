package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

public class Pokemon {
    private final String pokemonName;
    private final String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return pokemonName + " " + pokemonType;
    }
}
