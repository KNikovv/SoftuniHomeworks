package exercises;

import connection.Connector;
import entities.Book;
import orm.EntityManager;

import java.sql.SQLException;

public class AddNewEntity {

    public static void main(String[] args) {
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "users");
            EntityManager em = new EntityManager(Connector.getConnection());

//            Book book = new Book("Harry Potter and Kozel Maina Shveps Utaika Kon "
//                    , "Mitio Krika", new Date(), "EN", true);
//            Book book1 = new Book("Kozunak, konserva s med i olio vurhu bob"
//                    , "Valcho", new Date(), "BG", false);
//            Book book2 = new Book("Pekinez na furna s ocet i malko zahar"
//                    , "Gandalf", new Date(), "EN", true);
//            Book book3 = new Book("Utaika s duh na kanela"
//                    , "Leonardo", new Date(), "EN", false);
//            em.persist(book);
//            em.persist(book1);
//            em.persist(book2);
//            em.persist(book3);

            Iterable<Book> bookIterable = em.find(Book.class,
                    "CHAR_LENGTH(title) > 30 AND is_hard_covered=1");
            for (Book b : bookIterable) {
                String trimmedLength = b.getTitle().substring(0, 30);
                b.setTitle(trimmedLength);
                em.persist(b);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
