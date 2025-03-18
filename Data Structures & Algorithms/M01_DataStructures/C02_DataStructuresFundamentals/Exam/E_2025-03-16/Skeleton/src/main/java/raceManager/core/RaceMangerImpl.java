package raceManager.core;

import raceManager.models.Athlete;

import java.util.*;
import java.util.stream.Collectors;

public class RaceMangerImpl implements RaceManger {
    private final List<Athlete> allAthletes = new ArrayList<>();
    private final List<Athlete> running = new ArrayList<>();
    private final List<Athlete> retired = new ArrayList<>();
    private final Deque<Athlete> startLine = new ArrayDeque<>();
    private final Deque<Athlete> finished = new ArrayDeque<>();


    @Override
    public void enroll(Athlete athlete) {
        if (allAthletes.contains(athlete)) {
            throw new IllegalArgumentException();
        }

        allAthletes.add(athlete);
        startLine.offer(athlete);
    }

    @Override
    public boolean isEnrolled(Athlete athlete) {
        return allAthletes.contains(athlete);
    }

    @Override
    public void start() {
        Athlete starting = startLine.poll();

        if (starting == null) {
            throw new IllegalArgumentException();
        }

        running.add(starting);
    }

    @Override
    public void retire(Athlete athlete) {
        if (!running.contains(athlete)) {
            throw new IllegalArgumentException();
        }

        running.remove(athlete);
        retired.add(athlete);
    }

    @Override
    public void finish(Athlete athlete) {
        if (!running.contains(athlete)) {
            throw new IllegalArgumentException();
        }

        running.remove(athlete);
        finished.push(athlete);
    }

    @Override
    public Athlete getLastFinishedAthlete() {
        if (finished.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return finished.peek();
    }

    @Override
    public int currentRacingCount() {
        return running.size();
    }

    @Override
    public Collection<Athlete> getAllAthletesByAge() {
        return allAthletes.stream()
                .sorted(Comparator.comparingInt(l -> l.age))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Athlete> getAllNotFinishedAthletes() {
        ArrayList<Athlete> notFinished = new ArrayList<>();
        notFinished.addAll(startLine);
        notFinished.addAll(retired);

        return notFinished.stream()
                .sorted(Comparator.comparing(l -> l.name))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Athlete> getScoreBoard() {
        return finished.iterator();
    }
}
