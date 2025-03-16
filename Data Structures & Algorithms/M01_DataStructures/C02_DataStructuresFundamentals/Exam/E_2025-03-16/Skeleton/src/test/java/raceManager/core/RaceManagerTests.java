package raceManager.core;

import org.junit.Before;
import org.junit.Test;
import raceManager.models.Athlete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class RaceManagerTests {

    private RaceManger raceManager;

    private Athlete athlete = new Athlete("First", 20);

    @Before
    public void setup() {
        raceManager = new RaceMangerImpl();
    }

    @Test
    public void enroll() {
        raceManager.enroll(athlete);

        assertTrue(raceManager.isEnrolled(athlete));
    }

    @Test
    public void enrollMultipleAthletes() {
        List<Athlete> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Athlete current = new Athlete("Athlete " + i, i);

            list.add(current);
        }

        for (Athlete athlete1 : list) {
            raceManager.enroll(athlete1);
        }

        for (Athlete athlete1 : list) {
            assertTrue(raceManager.isEnrolled(athlete1));
        }

        assertFalse(raceManager.isEnrolled(athlete));
    }

    @Test
    public void retireRunningAthlete() {
        raceManager.enroll(athlete);
        raceManager.start();

        raceManager.retire(athlete);

        assertEquals(0, raceManager.currentRacingCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void finishNotEnrolledAthlete() {
        raceManager.finish(athlete);
    }

    @Test
    public void getLastFinishedAthlete() {
        raceManager.enroll(athlete);
        raceManager.start();
        raceManager.finish(athlete);

        assertEquals(athlete, raceManager.getLastFinishedAthlete());
    }

    @Test
    public void getAllNonFinishedAthletesWithEmptyManager() {
        Collection<Athlete> allAthletesByAge = raceManager.getAllNotFinishedAthletes();

        assertTrue(allAthletesByAge.isEmpty());
    }
}
