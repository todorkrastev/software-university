import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class  Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student("Todor", 32);
        entityManager.persist(student);

        Student first = entityManager.find(Student.class, 1);
        entityManager.remove(first);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
