import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class ConcurrentChangesToDb {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager firstEm = emf.createEntityManager();
        EntityManager secondEm = emf.createEntityManager();

        firstEm.getTransaction().begin();
        secondEm.getTransaction().begin();
        Employee e = firstEm.find(Employee.class, 1);
        firstEm.lock(e, LockModeType.PESSIMISTIC_WRITE);
        secondEm.lock(e,LockModeType.PESSIMISTIC_WRITE);
        e.setFirstName("Pesho");
        e.setFirstName("Gosho");

        firstEm.getTransaction().commit();
        secondEm.getTransaction().commit();

        firstEm.close();
        secondEm.close();
        emf.close();
    }
}
