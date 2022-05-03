package softuni.exam.service;

import softuni.exam.models.entities.Passenger;

import java.io.IOException;
import java.util.Optional;

public interface PassengerService {

    boolean areImported();

    String readPassengersFileContent() throws IOException;
	
	String importPassengers() throws IOException;

	String getPassengersOrderByTicketsCountDescendingThenByEmail();

    Optional<Passenger> getByEmail(String email);
}
