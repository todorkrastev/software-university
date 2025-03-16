package barbershopjava;

import java.util.Collection;

public interface BarberShop {

    void addBarber(Barber b);

    void addClient(Client c);

    boolean exist(Barber b);

    boolean exist(Client c);

    Collection<Barber> getBarbers();

    Collection<Client> getClients();

    void assignClient(Barber b, Client c);

    void deleteAllClientsFrom(Barber b);

    Collection<Client> getClientsWithNoBarber();

    Collection<Barber> getAllBarbersSortedWithClientsCountDesc();

    Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc();

    Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc();
}
