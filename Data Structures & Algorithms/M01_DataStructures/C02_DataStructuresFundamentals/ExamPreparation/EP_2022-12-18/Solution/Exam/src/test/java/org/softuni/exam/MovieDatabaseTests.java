package org.softuni.exam;

import org.junit.Before;
import org.junit.Test;
import org.softuni.exam.entities.Actor;
import org.softuni.exam.entities.Movie;
import org.softuni.exam.structures.MovieDatabase;
import org.softuni.exam.structures.MovieDatabaseImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class MovieDatabaseTests {
    private interface InternalTest {
        void execute();
    }

    private MovieDatabase movieDatabase;

    private Actor getRandomActor() {
        return new Actor(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                (int) Math.min(1, Math.random() * 1_000_000_000));
    }

    private Movie getRandomMovie() {
        return new Movie(
                UUID.randomUUID().toString(),
                (int) Math.min(1, Math.random() * 1_000_000_000),
                UUID.randomUUID().toString(),
                Math.min(1, Math.random() * 1_000_000_000),
                Math.min(1, Math.random() * 1_000_000_000));
    }

    @Before
    public void setup() {
        this.movieDatabase = new MovieDatabaseImpl();
    }

    public void performCorrectnessTesting(InternalTest[] methods) {
        Arrays.stream(methods)
                .forEach(method -> {
                    this.movieDatabase = new MovieDatabaseImpl();;

                    try {
                        method.execute();
                    } catch (IllegalArgumentException ignored) { }
                });

        this.movieDatabase = new MovieDatabaseImpl();
    }

    // Correctness Tests

    @Test
    public void testContains_WithExistentActor_ShouldReturnTrue() {
        Actor actor = getRandomActor();
        this.movieDatabase.addActor(actor);

        assertTrue(this.movieDatabase.contains(actor));
    }

    @Test
    public void testContains_WithNonExistentActor_ShouldReturnFalse() {
        Actor actor = getRandomActor();
        this.movieDatabase.addActor(actor);

        assertFalse(this.movieDatabase.contains(getRandomActor()));
    }

    @Test
    public void testContains_WithExistentMovie_ShouldReturnTrue() {
        Actor actor = getRandomActor();
        this.movieDatabase.addActor(actor);
        Movie movie = getRandomMovie();
        this.movieDatabase.addMovie(actor, movie);

        assertTrue(this.movieDatabase.contains(movie));
    }

    @Test
    public void testContains_WithNonExistentMovie_ShouldReturnFalse() {
        Actor actor = getRandomActor();
        this.movieDatabase.addActor(actor);
        Movie movie = getRandomMovie();
        this.movieDatabase.addMovie(actor, movie);

        assertFalse(this.movieDatabase.contains(getRandomMovie()));
    }

    @Test
    public void testGetNewbieActors_WithData_ShouldReturnCorrectResults() {
        Actor actor = getRandomActor();
        this.movieDatabase.addActor(actor);
        Actor actor2 = getRandomActor();
        this.movieDatabase.addActor(actor2);
        Actor actor3 = getRandomActor();
        this.movieDatabase.addActor(actor3);
        Movie movie1 = getRandomMovie();
        Movie movie2 = getRandomMovie();

        this.movieDatabase.addMovie(actor, movie1);
        this.movieDatabase.addMovie(actor, movie2);

        Set<Actor> set =
                StreamSupport.stream(this.movieDatabase.getNewbieActors().spliterator(), false)
                        .collect(Collectors.toSet());

        assertEquals(set.size(), 2);
        assertTrue(set.contains(actor2));
        assertTrue(set.contains(actor3));
    }

    // Performance Tests

    @Test
    public void testContainsUser_With100000Results_ShouldPassQuickly() {
        this.performCorrectnessTesting(new InternalTest[] {
                this::testContains_WithExistentActor_ShouldReturnTrue,
                this::testContains_WithNonExistentActor_ShouldReturnFalse
        });

        int count = 100000;

        Actor actor = null;

        for (int i = 0; i < count; i++)
        {
            if(i == count / 2)  {
                actor = getRandomActor();
                this.movieDatabase.addActor(actor);
            } else {
                this.movieDatabase.addActor(getRandomActor());
            }

        }

        long start = System.currentTimeMillis();

        this.movieDatabase.contains(actor);

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        assertTrue(elapsedTime <= 5);
    }
}
