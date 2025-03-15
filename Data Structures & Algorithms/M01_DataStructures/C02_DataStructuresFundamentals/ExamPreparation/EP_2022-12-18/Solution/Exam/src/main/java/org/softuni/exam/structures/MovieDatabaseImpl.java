package org.softuni.exam.structures;

import org.softuni.exam.entities.Actor;
import org.softuni.exam.entities.Movie;

import java.util.*;

public class MovieDatabaseImpl implements MovieDatabase {
    private Map<String, Actor> actors;
    private Map<String, Movie> movies;
    private Map<String, List<Movie>> actorMovies;

    public MovieDatabaseImpl() {
        this.actors = new LinkedHashMap<>();
        this.movies = new LinkedHashMap<>();
        this.actorMovies = new HashMap<>();
    }

    @Override
    public void addActor(Actor actor) {
        this.actors.put(actor.getId(), actor);
    }

    @Override
    public void addMovie(Actor actor, Movie movie) throws IllegalArgumentException {
        if (!contains(actor)) {
            throw new IllegalArgumentException();
        }
        this.movies.put(movie.getId(), movie);
        this.actorMovies.computeIfAbsent(actor.getId(), k -> new ArrayList<>()).add(movie);
    }

    @Override
    public boolean contains(Actor actor) {
        return this.actors.containsKey(actor.getId());
    }

    @Override
    public boolean contains(Movie movie) {
        return this.movies.containsKey(movie.getId());
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return this.movies.values();
    }

    @Override
    public Iterable<Actor> getNewbieActors() {
        List<Actor> newbieActors = new ArrayList<>();
        for (Actor actor : this.actors.values()) {
            if (!this.actorMovies.containsKey(actor.getId())) {
                newbieActors.add(actor);
            }
        }
        return newbieActors;
    }

    @Override
    public Iterable<Movie> getMoviesOrderedByBudgetThenByRating() {
        List<Movie> sortedMovies = new ArrayList<>(this.movies.values());
        sortedMovies.sort(Comparator.comparing(Movie::getBudget).reversed()
                .thenComparing(Movie::getRating, Comparator.reverseOrder()));
        return sortedMovies;
    }

    @Override
    public Iterable<Actor> getActorsOrderedByMaxMovieBudgetThenByMoviesCount() {
        List<Actor> sortedActors = new ArrayList<>(this.actors.values());
        sortedActors.sort(Comparator.comparing((Actor actor) -> this.actorMovies.getOrDefault(actor.getId(), Collections.emptyList()).stream()
                        .mapToDouble(Movie::getBudget).max().orElse(0)).reversed()
                .thenComparing((Actor actor) -> this.actorMovies.getOrDefault(actor.getId(), Collections.emptyList()).size(), Comparator.reverseOrder()));
        return sortedActors;
    }

    @Override
    public Iterable<Movie> getMoviesInRangeOfBudget(double lower, double upper) {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : this.movies.values()) {
            if (movie.getBudget() >= lower && movie.getBudget() <= upper) {
                filteredMovies.add(movie);
            }
        }
        filteredMovies.sort(Comparator.comparing(Movie::getRating).reversed());
        return filteredMovies;
    }
}