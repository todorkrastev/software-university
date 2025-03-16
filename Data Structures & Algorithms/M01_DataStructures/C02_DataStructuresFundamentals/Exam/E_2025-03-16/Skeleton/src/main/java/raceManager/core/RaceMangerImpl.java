package raceManager.core;

import raceManager.models.Athlete;

import java.util.*;

public class RaceMangerImpl implements RaceManger {

    private Deque<Athlete> enrolledAthletes = new ArrayDeque<>();
    private List<Athlete> startedAthletes = new ArrayList<>();
    private List<Athlete> finishedAthletes = new LinkedList<>();
    private List<Athlete> allEnrolledAthletes = new ArrayList<>();

    @Override
    public void enroll(Athlete athlete) {
        if (isEnrolled(athlete)) {
            throw new IllegalArgumentException("Athlete is already enrolled.");
        }
        enrolledAthletes.offer(athlete);
        allEnrolledAthletes.add(athlete);
    }

    @Override
    public boolean isEnrolled(Athlete athlete) {
        return allEnrolledAthletes.contains(athlete);
    }

    @Override
    public void start() {
        if (enrolledAthletes.isEmpty()) {
            throw new IllegalArgumentException("There are no athletes waiting to start.");
        }
        Athlete athlete = enrolledAthletes.poll();
        startedAthletes.add(athlete);
    }

    @Override
    public void retire(Athlete athlete) {
        if (!startedAthletes.contains(athlete)) {
            throw new IllegalArgumentException("The athlete never started the race.");
        }
        startedAthletes.remove(athlete);
    }

    @Override
    public void finish(Athlete athlete) {
        if (!startedAthletes.contains(athlete)) {
            throw new IllegalArgumentException("The athlete has not started the race.");
        }
        startedAthletes.remove(athlete);
        finishedAthletes.add(athlete);
    }

    @Override
    public Athlete getLastFinishedAthlete() {
        if (finishedAthletes.isEmpty()) {
            throw new IllegalArgumentException("There are no finished athletes.");
        }
        return finishedAthletes.get(finishedAthletes.size() - 1);
    }

    @Override
    public int currentRacingCount() {
        return startedAthletes.size();
    }

    @Override
    public Collection<Athlete> getAllAthletesByAge() {
        List<Athlete> allAthletes = new ArrayList<>(allEnrolledAthletes);
        allAthletes.sort(Comparator.comparingInt(Athlete::getAge));
        return allAthletes;
    }

    @Override
    public Collection<Athlete> getAllNotFinishedAthletes() {
        Set<Athlete> notFinishedAthletes = new HashSet<>(enrolledAthletes);
        notFinishedAthletes.addAll(startedAthletes);
        notFinishedAthletes.addAll(allEnrolledAthletes);
        notFinishedAthletes.removeAll(finishedAthletes);
        List<Athlete> sortedNotFinishedAthletes = new ArrayList<>(notFinishedAthletes);
        sortedNotFinishedAthletes.sort(Comparator.comparing(Athlete::getName));
        return sortedNotFinishedAthletes;
    }

    @Override
    public Iterator<Athlete> getScoreBoard() {
        List<Athlete> scoreboard = new ArrayList<>(finishedAthletes);
        Collections.reverse(scoreboard);
        return scoreboard.iterator();
    }
}