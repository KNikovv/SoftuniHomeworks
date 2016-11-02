import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class FindEmployeesByFirstName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Query findEmp = em.createQuery("select e from Employee e where e.firstName like :pattern");
        findEmp.setParameter("pattern",  pattern + "%");
        List<Employee> emps = findEmp.getResultList();

        emps.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)\n",
                e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
        em.close();
        emf.close();
    }
}
