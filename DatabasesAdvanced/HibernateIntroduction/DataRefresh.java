import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataRefresh {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee e = em.find(Employee.class, 4);
        e.setFirstName(e.getFirstName().toUpperCase());
        em.refresh(e);
        em.persist(e);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
