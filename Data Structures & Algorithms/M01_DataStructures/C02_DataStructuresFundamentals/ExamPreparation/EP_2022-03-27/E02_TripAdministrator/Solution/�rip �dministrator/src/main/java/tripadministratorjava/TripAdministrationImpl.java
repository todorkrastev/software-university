package tripadministratorjava;

import java.util.*;

public class TripAdministrationImpl implements TripAdministration {

    private Map<String, Company> companies;
    private Map<String, Trip> trips;
    private Map<Company, Set<Trip>> companyTrips;

    public TripAdministrationImpl() {
        this.companies = new HashMap<>();
        this.trips = new HashMap<>();
        this.companyTrips = new HashMap<>();
    }

    @Override
    public void addCompany(Company c) {
        if (companies.containsKey(c.name)) {
            throw new IllegalArgumentException("Company already exists");
        }
        companies.put(c.name, c);
        companyTrips.put(c, new HashSet<>());
    }

    @Override
    public void addTrip(Company c, Trip t) {
        if (!companies.containsKey(c.name)) {
            throw new IllegalArgumentException("Company does not exist");
        }
        Set<Trip> tripsForCompany = companyTrips.get(c);
        if (tripsForCompany.size() >= c.tripOrganizationLimit) {
            throw new IllegalArgumentException("Company has reached its trip organization limit");
        }
        if (tripsForCompany.contains(t)) {
            throw new IllegalArgumentException("Trip already exists for the company");
        }
        trips.put(t.id, t);
        tripsForCompany.add(t);
    }

    @Override
    public boolean exist(Company c) {
        return companies.containsKey(c.name);
    }

    @Override
    public boolean exist(Trip t) {
        return trips.containsKey(t.id);
    }

    @Override
    public void removeCompany(Company c) {
        if (!companies.containsKey(c.name)) {
            throw new IllegalArgumentException("Company does not exist");
        }
        companies.remove(c.name);
        Set<Trip> tripsForCompany = companyTrips.remove(c);
        for (Trip trip : tripsForCompany) {
            trips.remove(trip.id);
        }
    }

    @Override
    public Collection<Company> getCompanies() {
        return new ArrayList<>(companies.values());
    }

    @Override
    public Collection<Trip> getTrips() {
        return new ArrayList<>(trips.values());
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        if (!companies.containsKey(c.name) || !trips.containsKey(t.id)) {
            throw new IllegalArgumentException("Company or Trip does not exist");
        }
        Set<Trip> tripsForCompany = companyTrips.get(c);
        if (!tripsForCompany.remove(t)) {
            throw new IllegalArgumentException("Trip does not belong to the provided company");
        }
        trips.remove(t.id);
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        List<Company> result = new ArrayList<>();
        for (Map.Entry<Company, Set<Trip>> entry : companyTrips.entrySet()) {
            if (entry.getValue().size() > n) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        List<Trip> result = new ArrayList<>();
        for (Trip trip : trips.values()) {
            if (trip.transportation == t) {
                result.add(trip);
            }
        }
        return result;
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        List<Trip> result = new ArrayList<>();
        for (Trip trip : trips.values()) {
            if (trip.price >= lo && trip.price <= hi) {
                result.add(trip);
            }
        }
        return result;
    }
}