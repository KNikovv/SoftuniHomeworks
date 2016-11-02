import entities.softuni.Employee;
import entities.softuni.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DeleteById {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query q = em.createQuery("select e from Employee as e  join e.projects as p where p.projectId=2");
        List<Employee> employees = q.getResultList();
        Project p = em.find(Project.class, 2);
        for (Employee employee : employees) {
            employee.getProjects().remove(p);
        }
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
