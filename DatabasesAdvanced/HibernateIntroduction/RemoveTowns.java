import entities.softuni.Address;
import entities.softuni.Town;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String townToRemove = scanner.nextLine();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();
            Query findTown = em.createQuery("select t from Town as t where t.name = :name");
            findTown.setParameter("name", townToRemove);
            Town town = (Town) findTown.getSingleResult();

            Query findAddr = em.createQuery("select a From Address as a where a.town = :town");
            findAddr.setParameter("town", town);
            List<Address> addresses = findAddr.getResultList();
            int deletedCount = addresses.size();

            for (Address a : addresses) {
                em.remove(a);
            }

            System.out.printf(deletedCount == 1 ?
                    String.format("1 address in %s was deleted.", townToRemove) :
                    String.format("%d addresses in %s were deleted.", deletedCount, townToRemove));

            em.remove(town);
            em.getTransaction().commit();

        } catch (NoResultException nre) {
            System.out.println(nre.getMessage());
        }

        em.close();
        emf.close();
    }
}
