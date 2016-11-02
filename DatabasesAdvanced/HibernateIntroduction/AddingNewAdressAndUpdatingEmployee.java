import entities.softuni.Address;
import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AddingNewAdressAndUpdatingEmployee {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address newAdr = new Address();
        newAdr.setAddressText("Vitoshka 15");
        em.persist(newAdr);
        Query q = em.createQuery("select e from Employee as e where e.lastName = 'Nakov'");
        Employee e = (Employee) q.getSingleResult();

        e.setAddress(newAdr);
        System.out.println(e.getAddress().getAddressText());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
