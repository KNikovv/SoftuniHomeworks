import entities.gringotts.WizzardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class DepositsSumForOllivanderFamily {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager em = emf.createEntityManager();

        WizzardDeposit wi = em.find(WizzardDeposit.class, 1);

        Query query = em.createQuery("select w.depositGroup,SUM(w.depositAmount)from WizzardDeposit w where w" +
                ".magicWandCreator = 'Ollivander family' group by w.depositGroup");
        List<Object[]> obj = query.getResultList();
        for (Object[] objects : obj) {
            String depositGroupName = (String) objects[0];
            BigDecimal sum = (BigDecimal) objects[1];
            System.out.printf("%s - %.2f\n", depositGroupName, sum);
        }
        em.close();
        emf.close();
    }
}
