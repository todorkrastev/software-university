import entities.BasicLabel;
import entities.BasicShampoo;
import entities.ProductionBatch;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermarket");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        ProductionBatch productionBatch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("blue");
        BasicShampoo shampoo = new BasicShampoo("shower", label, productionBatch);

        entityManager.persist(productionBatch);
        entityManager.persist(label);
        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
    }
}
