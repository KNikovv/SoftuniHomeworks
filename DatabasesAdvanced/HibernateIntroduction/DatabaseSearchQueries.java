import entities.softuni.Address;
import entities.softuni.Department;
import entities.softuni.Employee;
import entities.softuni.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class DatabaseSearchQueries {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        //1 Find all employees with ...

        Query first = em.createQuery("select e from Employee as e join e.projects as p" +
                " where p.startDate >= '2001-01-01' and p.startDate<='2003-12-31'");
        List<Employee> emp = first.getResultList();
        for (Employee employee : emp) {
            System.out.printf("Employee: %s %s ManagerName: %s\n",
                    employee.getFirstName(), employee.getLastName(), employee.getManager().getFirstName());
            System.out.printf("List of %s`s projects:--------\n", employee.getFirstName() + " " +
                    employee.getLastName());
            employee.getProjects().forEach(p -> System.out.printf("ProjectName: %s| StartDate: %s, EndDate: %s\n",
                    p.getName(), p.getStartDate(), p.getEndDate() == null ? "Undefined" : p.getEndDate()));
        }

        //2 Find all addresses ordered ...

        Query second = em.createQuery("select a from Address as a order by a.employees.size DESC ,a.town.name ASC");
        second.setMaxResults(10);
        List<Address> addresses = second.getResultList();
        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees\n",
                    address.getAddressText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }

        //3 Get employee

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        Employee e = em.find(Employee.class, id);
        System.out.printf("FirstName:%s, LastName:%s, JobTitle: %s\n",
                e.getFirstName(), e.getLastName(), e.getJobTitle());
        List<Project> projectsList = e.getProjects();
        System.out.println("EmployeesProjects--------");
        projectsList.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("ProjectName: %s\n", p.getName()));

        scanner.close();

        //4 Find all departments with ...

        Query fourth = em.createQuery("select d from Department as d " +
                "where d.employees.size> 5 order by d.employees.size asc");

        List<Department> departments = fourth.getResultList();

        for (Department department : departments) {
            System.out.printf("--%s - Manager: %s, Employees: %d\n",
                    department.getName(),
                    department.getManager().getLastName(),
                    department.getEmployees().size());
        }
        em.close();
        emf.close();
    }
}
