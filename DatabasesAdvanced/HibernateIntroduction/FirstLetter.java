import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FirstLetter {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select substring(w.firstName,1,1) as p  from WizzardDeposit w where w" +
                ".depositGroup='Troll Chest' group by substring(w.firstName,1,1) ");
        List<String> letters = q.getResultList();

        for (String letter : letters) {
            System.out.println(letter);
        }
        em.close();
        emf.close();
    }
}
