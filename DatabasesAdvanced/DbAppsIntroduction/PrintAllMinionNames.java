import java.sql.*;
import java.util.LinkedList;

public class PrintAllMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {

        String getMinions = "SELECT name FROM minions";
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<String> resultList = new LinkedList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement();
        ) {
            String getCount = "SELECT COUNT(*) AS c FROM minions";
            ResultSet query = statement.executeQuery(getCount);
            int size = query.next() ? query.getInt("c") : 0;
            query = statement.executeQuery(getMinions);
            int temp = size;
            while (query.next()) {
                linkedList.add(query.getString("name"));
            }
            while (!linkedList.isEmpty()) {
                String first = linkedList.poll();
                String last = linkedList.pollLast();

                resultList.add(first);
                resultList.add(last);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        if (resultList.peekLast() == null) {
            resultList.pollLast();
        }

        resultList.forEach(System.out::println);
    }
}
