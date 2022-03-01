import entities.BasicIngredient;
import entities.BasicLabel;
import entities.BasicShampoo;
import entities.ProductionBatch;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermarket");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        ProductionBatch productionBatch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("blue");
        BasicShampoo shampoo = new BasicShampoo("shower", label, productionBatch);

        BasicIngredient glycol = new BasicIngredient(5, "Glycol");
        BasicIngredient citricAcid = new BasicIngredient(2, "Citric acid");

        shampoo.addIngredient(glycol);
        shampoo.addIngredient(citricAcid);

        entityManager.persist(productionBatch);
        entityManager.persist(label);
        entityManager.persist(shampoo);
        entityManager.persist(glycol);
        entityManager.persist(citricAcid);

        entityManager.getTransaction().commit();
    }
}
