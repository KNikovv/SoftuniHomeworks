package exercises;

import connection.Connector;
import entities.Book;
import orm.EntityManager;

import java.sql.SQLException;
import java.util.Date;

public class UpdateEntity {

    public static void main(String[] args) {
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "users");
            EntityManager em = new EntityManager(Connector.getConnection());

            Book book = new Book("Harry Potter and Kozel Maina Shveps Utaika Kon "
                    , "Mitio Krika", new Date(), "EN", true, 5);
            Book book1 = new Book("Kozunak, konserva s med i olio vurhu bob"
                    , "Valcho", new Date(), "BG", false, 6);
            Book book2 = new Book("Pekinez na furna s ocet i malko zahar"
                    , "Gandalf", new Date(), "EN", true, 4);
            Book book3 = new Book("Utaika s duh na kanela"
                    , "Leonardo", new Date(), "EN", false, 1);
            em.persist(book);
            em.persist(book1);
            em.persist(book2);
            em.persist(book3);
            String filter = "1=1 ORDER BY rating DESC,title ASC LIMIT 3";
            Iterable<Book> books = em.find(Book.class, filter);
            for (Book b : books) {
                System.out.printf("Title: %s, Author: %s, Rating: %d\n",
                        b.getTitle(), b.getAuthor(), b.getRating());
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }
}
