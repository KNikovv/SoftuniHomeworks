import entities.softuni.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FindLatest10Projects {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select p from Project as p ORDER BY p.startDate desc");
        q.setMaxResults(10);
        List<Project> projects = q.getResultList();

        projects.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("Name:%s, Descr:%s, Start:%s, End:%s\n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate()));

        em.close();
        emf.close();
    }
}
