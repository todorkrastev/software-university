package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private final List<Pokemon> pokemonList;
    private final List<Parents> parentsList;
    private final List<Children> childrenList;
    private Car car;

    public Person() {
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Company:")
                .append(System.lineSeparator());
        if (company != null) {
            stringBuilder.append(company)
                    .append(System.lineSeparator());
        }

        stringBuilder.append("Car:")
                .append(System.lineSeparator());
        if (car != null) {
            stringBuilder.append(car)
                    .append(System.lineSeparator());
        }

        stringBuilder.append("Pokemon:")
                .append(System.lineSeparator());

        if (!pokemonList.isEmpty()) {
            pokemonList
                    .forEach(pokemon -> stringBuilder.append(pokemon)
                            .append(System.lineSeparator()));
        }

        stringBuilder.append("Parents:")
                .append(System.lineSeparator());

        if (!parentsList.isEmpty()) {
            parentsList
                    .forEach(parents -> stringBuilder.append(parents)
                            .append(System.lineSeparator()));
        }


        stringBuilder.append("Children:")
                .append(System.lineSeparator());

        if (!childrenList.isEmpty()) {
            childrenList
                    .forEach(children -> stringBuilder.append(children)
                            .append(System.lineSeparator()));
        }
        return stringBuilder.toString();
    }
}

