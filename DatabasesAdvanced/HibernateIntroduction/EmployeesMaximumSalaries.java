import entities.softuni.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class EmployeesMaximumSalaries {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select d, MAX(e.salary) from Department d " +
                "join d.employees e group by d.departmentId having max(e.salary) not between 30000 and 70000");
        List<Object[]> resultList = q.getResultList();

        for (Object[] obj : resultList) {
            Department dep = (Department) obj[0];
            BigDecimal maxSalary = (BigDecimal) obj[1];
            System.out.printf("%s - %.2f\n", dep.getName(), maxSalary);
        }
        em.close();
        emf.close();
    }
}
