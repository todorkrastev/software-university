package org.softuni.exam.structures;

import org.softuni.exam.entities.Actor;
import org.softuni.exam.entities.Movie;

public class MovieDatabaseImpl implements MovieDatabase {

    @Override
    public void addActor(Actor actor) {

    }

    @Override
    public void addMovie(Actor actor, Movie movie) throws IllegalArgumentException {

    }

    @Override
    public boolean contains(Actor actor) {
        return false;
    }

    @Override
    public boolean contains(Movie movie) {
        return false;
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Iterable<Actor> getNewbieActors() {
        return null;
    }

    @Override
    public Iterable<Movie> getMoviesOrderedByBudgetThenByRating() {
        return null;
    }

    @Override
    public Iterable<Actor> getActorsOrderedByMaxMovieBudgetThenByMoviesCount() {
        return null;
    }

    @Override
    public Iterable<Movie> getMoviesInRangeOfBudget(double lower, double upper) {
        return null;
    }
}
