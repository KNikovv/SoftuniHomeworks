import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesFromSeattle {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select e from Employee as e join e.department as e1 " +
                "where e1.name='Research and Development'");
        List<Employee> employees = query.getResultList();
        employees.stream()
                .sorted((e1, e2) -> {
                        int compare = e1.getSalary().compareTo(e2.getSalary());
                            if (compare == 0) {
                            compare = e2.getFirstName().compareTo(e1.getFirstName());
                            }
                        return compare;
                })
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f\n",
                e.getFirstName(),
                e.getLastName(),
                e.getDepartment().getName(),
                e.getSalary()));

        em.close();
        emf.close();
    }
}
