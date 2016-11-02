import entities.softuni.Address;
import entities.softuni.Department;
import entities.softuni.Employee;
import entities.softuni.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CreateObjects {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department training = addDepartment(em);

        Town bourgas = addTown(em);

        List<Address> addresses = addAddresses(em, bourgas);

        addEmployees(em, training, addresses);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void addEmployees(EntityManager em, Department training, List<Address> addresses) {
        String[] names = {"Pesho", "Kesho", "Mesho", "Gesho", "Vesho"};
        BigDecimal[] salaries = new BigDecimal[]{
                BigDecimal.valueOf(10000),
                BigDecimal.valueOf(15000),
                BigDecimal.valueOf(9000)};

        for (int i = 0; i < 5; i++) {
            Employee e = new Employee();
            e.setFirstName(names[i]);
            e.setLastName("Ivanov");
            e.setJobTitle("Trainer");
            e.setDepartment(training);
            e.setAddress(addresses.get(i % addresses.size()));
            e.setHireDate(new Date());
            e.setSalary(salaries[i % salaries.length]);
            em.persist(e);
        }
    }

    private static List<Address> addAddresses(EntityManager em, Town bourgas) {
        List<Address> addresses = new LinkedList<>();

        String[] adressTexts = {"Kozq polqna 12", "Ovcha polqna 5", "Konska polqna 1"};
        for (int i = 0; i < 3; i++) {
            Address a = new Address();
            a.setTown(bourgas);
            a.setAddressText(adressTexts[i]);
            em.persist(a);
            addresses.add(a);
        }
        return addresses;
    }

    private static Town addTown(EntityManager em) {
        Town bourgas = new Town();
        bourgas.setName("Bourgas");
        em.persist(bourgas);
        return bourgas;
    }

    private static Department addDepartment(EntityManager em) {
        Department training = new Department();
        Employee manager = em.find(Employee.class, 1);
        training.setName("Training");
        training.setManager(manager);
        em.persist(training);
        return training;
    }
}
