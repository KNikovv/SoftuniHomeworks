package exercises;

import connection.Connector;
import entities.Book;
import orm.EntityManager;

import java.sql.SQLException;

public class DeleteRecords {

    public static void main(String[] args) {
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "users");
            EntityManager em = new EntityManager(Connector.getConnection());

            String select = " rating < 2 ";

            Iterable<Book> books = em.find(Book.class, select);

            int deletedCount = 0;
            for (Book book : books) {
                em.deleteObjById(Book.class, book.getId());
                deletedCount++;
            }
            System.out.printf("%d books have been deleted from the database.", deletedCount);
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
