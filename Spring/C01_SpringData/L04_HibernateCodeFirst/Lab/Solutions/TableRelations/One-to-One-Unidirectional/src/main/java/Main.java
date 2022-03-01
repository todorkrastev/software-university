import entities.BasicLabel;
import entities.BasicShampoo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermarket");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        BasicLabel label = new BasicLabel("blue");
        BasicShampoo shampoo = new BasicShampoo("shower", label);

        entityManager.persist(label);
        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
    }
}
