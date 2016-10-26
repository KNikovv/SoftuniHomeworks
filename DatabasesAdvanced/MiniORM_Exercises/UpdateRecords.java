package exercises;

import connection.Connector;
import entities.Book;
import orm.EntityManager;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UpdateRecords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "users");
            EntityManager em = new EntityManager(Connector.getConnection());

            int year = scanner.nextInt();
            String select = "YEAR(published_on) >=" + year + " AND is_hard_covered = 1";
            Iterable<Book> books = em.find(Book.class, select);
            List<String> updated = new LinkedList<>();
            int updateCount = 0;
            for (Book b : books) {
                String toUpper = b.getTitle().toUpperCase();
                b.setTitle(toUpper);
                em.persist(b);
                updated.add(toUpper);
            }

            System.out.printf("Books released after %d year: %d\n", year, updateCount);
            updated.stream().sorted().forEach(System.out::println);
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
