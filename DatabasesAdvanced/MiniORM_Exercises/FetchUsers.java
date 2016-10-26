package exercises;

import connection.Connector;
import entities.User;
import orm.EntityManager;

import java.sql.SQLException;

public class FetchUsers {

    public static void main(String[] args) {
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "users");
            EntityManager em = new EntityManager(Connector.getConnection());

            Iterable<User> filteredUsers = em.find(
                    User.class, "YEAR(registration_date)>2010 AND age>=18");

            filteredUsers.forEach
                    (u -> System.out.printf("Username : %s, Password: %s\n",
                            u.getUsername(), u.getPassword()));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
