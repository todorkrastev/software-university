package tripadministratorjava;

import java.util.Collection;

public interface TripAdministration {
    void addCompany(Company c);

    void addTrip(Company c, Trip t);

    boolean exist(Company c);

    boolean exist(Trip t);

    void removeCompany(Company c);

    Collection<Company> getCompanies();

    Collection<Trip> getTrips();

    void executeTrip(Company c, Trip t);

    Collection<Company> getCompaniesWithMoreThatNTrips(int n);

    Collection<Trip> getTripsWithTransportationType(Transportation t);

    Collection<Trip> getAllTripsInPriceRange(int lo, int hi);
}