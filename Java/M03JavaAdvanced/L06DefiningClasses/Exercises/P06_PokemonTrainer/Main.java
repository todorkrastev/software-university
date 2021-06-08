package bg.softuni.java_advanced.defining_classes.exercises.P06_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Trainer> participantsMap = new LinkedHashMap<>();

        String command;
        String[] tokens;
        while (!"Tournament".equals(command = reader.readLine())) {
            tokens = command.trim().split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            participantsMap.putIfAbsent(trainerName, new Trainer(trainerName, 0, new ArrayList<>()));
            participantsMap.get(trainerName).getCollectionOfPokemon().add(pokemon);
        }
        while (!"End".equals(command = reader.readLine())) {
            for (Trainer value : participantsMap.values()) {
                String finalInput = command;
                boolean isFound = value.getCollectionOfPokemon().stream()
                        .anyMatch(e -> e.getElement().equals(finalInput));
                if (isFound) {
                    value.setNumOfBadges(value.getNumOfBadges() + 1);
                } else {
                    value
                            .getCollectionOfPokemon()
                            .forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
                    value
                            .setCollectionOfPokemon(value.getCollectionOfPokemon()
                                    .stream()
                                    .filter(e -> e.getHealth() > 0)
                                    .collect(Collectors.toList()));
                }
            }
        }
        participantsMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Trainer>
                        comparingByValue(Comparator.comparing(Trainer::getNumOfBadges)).reversed())
                .forEach(e -> System.out.printf("%s %d %d%n"
                        , e.getValue().getName()
                        , e.getValue().getNumOfBadges()
                        , e.getValue().getCollectionOfPokemon().size()));
    }
}
