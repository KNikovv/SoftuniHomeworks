import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayID = scanner.nextLine().split(" ");

        String queryMinions =
                String.format("SELECT * FROM minions WHERE minion_id IN (%s)",
                        Arrays.toString(arrayID).replaceAll("[\\[\\]]",""));
        StringBuilder result = new StringBuilder();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement();

        ) {
            String update = String.format("UPDATE minions " +
                    "SET age = age + 1," +
                            "name = CONCAT(UPPER(LEFT(name, 1))," +
                                    "SUBSTRING(name, 2)) " +
                    "WHERE minion_id IN (%s);",
                    Arrays.toString(arrayID).replaceAll("[\\[\\]]",""));
            statement.execute(update);
            String selectAllMinions = "SELECT name,age FROM minions";
            ResultSet resultSet = statement.executeQuery(selectAllMinions);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                result.append(name).append(" ").append(age);
                result.append(System.lineSeparator());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }
}
