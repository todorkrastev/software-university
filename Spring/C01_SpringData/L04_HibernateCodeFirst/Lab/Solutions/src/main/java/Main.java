import entities.Car;
import entities.Truck;
import entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager vehicles_db =
                Persistence.createEntityManagerFactory("vehicles_db").createEntityManager();
        List<Vehicle> vehicles = List.of(
                new Car(4, "Ford Mondeo", "Pesho"),
                new Truck(1000, 2, "Ivan"),
                new Car(5, "Chevrolet Curvet", "Gosho"),
                new Truck(2000, 1, "Tseco"));

        vehicles_db.getTransaction().begin();
        vehicles.forEach(vehicles_db::persist);
        vehicles_db.getTransaction().commit();

    }
}
