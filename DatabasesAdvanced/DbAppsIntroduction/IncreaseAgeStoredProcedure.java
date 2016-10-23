import java.sql.*;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String callProcedure = String.format("CALL usp_increase_age (%d)", id);
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                CallableStatement statement = connection.prepareCall(callProcedure);
        ) {
            statement.execute();
            String select = "SELECT name,age FROM minions WHERE minion_id = " + id;
            ResultSet resultSet = statement.executeQuery(select);
            String result = resultSet.next() ?
                    resultSet.getString("name") + " " + resultSet.getInt("age") :
                    null;

            System.out.println(result == null ? "No such minion" : result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
