import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesWithSalaryOver50000 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();


        Query jpql = em.createQuery("select e.firstName from Employee as e where e.salary> 50000");
        List<String> firstNames = jpql.getResultList();

        for (String firstName : firstNames) {
            System.out.println(firstName);
        }


        em.close();
        emf.close();
    }
}
