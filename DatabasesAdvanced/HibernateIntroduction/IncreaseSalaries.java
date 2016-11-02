import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query q = em.createQuery("select e from Employee e join e.department d" +
                " where d.name in ('Engineering','Tool Design','Marketing','Information Service')");
        List<Employee> emps = q.getResultList();

        for (Employee emp : emps) {
            emp.setSalary(emp.getSalary().multiply(BigDecimal.valueOf(1.12)));
        }
        emps.forEach(e -> System.out.printf("Name:%s, Salary: %.2f\n",
                e.getFirstName() + " " + e.getLastName(),
                e.getSalary()));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
