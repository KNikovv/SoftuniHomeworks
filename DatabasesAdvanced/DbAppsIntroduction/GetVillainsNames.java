import java.sql.*;

public class GetVillainsNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        String query =
                "SELECT v.villain_name,COUNT(vm.minion_id) AS minion_count " +
                        "FROM villains AS v" +
                        "  JOIN villains_minions AS vm ON v.villain_id = vm.villain_id\n" +
                        "  GROUP BY v.villain_id\n" +
                        "HAVING minion_count > 3\n" +
                        "ORDER BY minion_count DESC; ";
        StringBuilder stringBuilder = new StringBuilder();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
        ) {

            while (result.next()) {
                String name = result.getString("villain_name");
                int count = result.getInt("minion_count");
                stringBuilder.append(String.format("%s %d",name,count));
                stringBuilder.append(System.lineSeparator());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(stringBuilder.length() > 0) {
            System.out.println(stringBuilder.toString());
        }
    }
}
