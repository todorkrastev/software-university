package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class AirlinesManagerImpl implements AirlinesManager {
    private Map<String, Airline> airlines;
    private Map<String, Flight> flights;
    private Map<Airline, List<Flight>> airlineFlights;
    private Map<String, Flight> completedFlights;

    public AirlinesManagerImpl() {
        this.airlines = new LinkedHashMap<>();
        this.flights = new LinkedHashMap<>();
        this.airlineFlights = new LinkedHashMap<>();
        this.completedFlights = new LinkedHashMap<>();
    }

    @Override
    public void addAirline(Airline airline) {
        this.airlines.put(airline.getId(), airline);
        this.airlineFlights.putIfAbsent(airline, new ArrayList<>());
    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
        if (!this.contains(airline)) {
            throw new IllegalArgumentException();
        }
        this.flights.put(flight.getId(), flight);
        this.airlineFlights.get(airline).add(flight);
        if (flight.isCompleted()) {
            this.completedFlights.put(flight.getId(), flight);
        }
    }

    @Override
    public boolean contains(Airline airline) {
        return this.airlines.containsKey(airline.getId());
    }

    @Override
    public boolean contains(Flight flight) {
        return this.flights.containsKey(flight.getId());
    }

    @Override
    public void deleteAirline(Airline airline) {
        if (!this.contains(airline)) {
            throw new IllegalArgumentException();
        }
        List<Flight> associatedFlights = this.airlineFlights.remove(airline);
        for (Flight flight : associatedFlights) {
            this.flights.remove(flight.getId());
            this.completedFlights.remove(flight.getId());
        }
        this.airlines.remove(airline.getId());
    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return this.flights.values();
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) {
        if (!this.contains(airline) || !this.contains(flight)) {
            throw new IllegalArgumentException();
        }
        flight.setCompleted(true);
        this.completedFlights.put(flight.getId(), flight);
        return flight;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return this.completedFlights.values();
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        List<Flight> sortedFlights = new ArrayList<>(this.flights.values());
        sortedFlights.sort(Comparator.comparing(Flight::isCompleted)
                .thenComparing(Flight::getNumber));
        return sortedFlights;
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        List<Airline> sortedAirlines = new ArrayList<>(this.airlines.values());
        sortedAirlines.sort(Comparator.comparing(Airline::getRating)
                .thenComparing((Airline a) -> this.airlineFlights.get(a).size()).reversed()
                .thenComparing(Airline::getName));
        return sortedAirlines;
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        return airlines
                .values()
                .stream()
                .filter(airline -> airlineFlights.get(airline).stream().anyMatch(
                        flight -> !flight.isCompleted() && flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)))
                .collect(Collectors.toList());
    }
}