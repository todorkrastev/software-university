package barbershopjava;

import java.util.*;

public class BarberShopImpl implements BarberShop {
    private Map<String, Barber> barbers;
    private Map<String, Client> clients;
    private Map<Barber, List<Client>> barberClients;

    public BarberShopImpl() {
        this.barbers = new HashMap<>();
        this.clients = new HashMap<>();
        this.barberClients = new HashMap<>();
    }

    @Override
    public void addBarber(Barber b) {
        if (barbers.containsKey(b.getName())) {
            throw new IllegalArgumentException("Barber already exists");
        }
        barbers.put(b.getName(), b);
        barberClients.put(b, new ArrayList<>());
    }

    @Override
    public void addClient(Client c) {
        if (clients.containsKey(c.getName())) {
            throw new IllegalArgumentException("Client already exists");
        }
        clients.put(c.getName(), c);
    }

    @Override
    public boolean exist(Barber b) {
        return barbers.containsKey(b.getName());
    }

    @Override
    public boolean exist(Client c) {
        return clients.containsKey(c.getName());
    }

    @Override
    public Collection<Barber> getBarbers() {
        //return new ArrayList<>(barbers.values());
        return barbers.values();
    }

    @Override
    public Collection<Client> getClients() {
        //return new ArrayList<>(clients.values());
        return clients.values();
    }

    @Override
    public void assignClient(Barber b, Client c) {
        if (!barbers.containsKey(b.getName()) || !clients.containsKey(c.getName())) {
            throw new IllegalArgumentException("Barber or Client does not exist");
        }
        barberClients.get(b).add(c);
        c.setBarber(b);
    }

    @Override
    public void deleteAllClientsFrom(Barber b) {
        if (!barbers.containsKey(b.getName())) {
            throw new IllegalArgumentException("Barber does not exist");
        }
        barberClients.get(b).clear();
    }

    @Override
    public Collection<Client> getClientsWithNoBarber() {
        List<Client> clientsWithNoBarber = new ArrayList<>();
        for (Client client : clients.values()) {
            if (client.getBarber() == null) {
                clientsWithNoBarber.add(client);
            }
        }
        return clientsWithNoBarber;
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithClientsCountDesc() {
        List<Barber> sortedBarbers = new ArrayList<>(barbers.values());
        sortedBarbers.sort((b1, b2) -> Integer.compare(barberClients.get(b2).size(), barberClients.get(b1).size()));
        return sortedBarbers;
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        List<Barber> sortedBarbers = new ArrayList<>(barbers.values());
        sortedBarbers.sort(Comparator.comparingInt(Barber::getStars).reversed()
                .thenComparingDouble(Barber::getHaircutPrice));
        return sortedBarbers;
    }

    @Override
    public Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc() {
        List<Client> sortedClients = new ArrayList<>();
        for (Map.Entry<Barber, List<Client>> entry : barberClients.entrySet()) {
            Barber barber = entry.getKey();
            for (Client client : entry.getValue()) {
                sortedClients.add(client);
            }
        }
        sortedClients.sort(Comparator.comparingInt(Client::getAge).reversed()
                .thenComparing((c1, c2) -> Integer.compare(c2.getBarber().getStars(), c1.getBarber().getStars())));
        return sortedClients;
    }
}