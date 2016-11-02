import entities.softuni.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RemoveObject {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //

        Query jpql = em.createQuery("SELECT t from Town as t");
        List<Town> townList = jpql.getResultList();

        detachTowns(em, townList);

        townList.forEach(t -> t.setName(t.getName().toLowerCase()));

        //
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void detachTowns(EntityManager em, List<Town> townList) {
        for (Town town : townList) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }
        }
    }
}
