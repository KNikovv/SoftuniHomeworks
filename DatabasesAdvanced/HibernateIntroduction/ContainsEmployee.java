import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String empName = scanner.nextLine();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();



        Query jpql = em.createQuery("SELECT e FROM Employee as e WHERE CONCAT(e.firstName,' ',e.lastName) = :name",
                Employee.class);
        jpql.setParameter("name", empName);
        List<Employee> employees = jpql.getResultList();
        System.out.println(employees.size() > 0 ? "Yes" : "No");

        em.close();
        emf.close();
    }
}
