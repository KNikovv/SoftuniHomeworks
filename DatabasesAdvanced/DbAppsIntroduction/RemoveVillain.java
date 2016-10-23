import java.sql.*;
import java.util.Scanner;

public class RemoveVillain {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int villain_idToDelete = scanner.nextInt();

        StringBuilder result = new StringBuilder();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement();
        ) {
            String countMinions = "SELECT COUNT(*) as c FROM villains_minions" +
                    " WHERE villain_id = " + villain_idToDelete;
            ResultSet resultSet = statement.executeQuery(countMinions);
            int releasedCount = resultSet.next() ? resultSet.getInt("c") : 0;
            String getVillainName = "SELECT villain_name FROM villains WHERE" +
                    " villain_id = " + villain_idToDelete;
            resultSet = statement.executeQuery(getVillainName);
            String deletedVillainName = resultSet.next() ? resultSet.getString("villain_name") : null;
            String deleteFromMappingTable = "DELETE FROM villains_minions WHERE " +
                    "villain_id =" + villain_idToDelete;
            String deleteFromVillainTable = "DELETE FROM villains WHERE " +
                    "villain_id = " + villain_idToDelete;
            statement.executeUpdate(deleteFromMappingTable);
            statement.executeUpdate(deleteFromVillainTable);

            String minionsReleased = releasedCount == 1 ?
                    "1 minion released" :
                    releasedCount + " minions released";

            result.append(deletedVillainName == null ? "No such villain found" :
                    String.format("%s was deleted\n %s",
                            deletedVillainName, minionsReleased));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(result.toString());
    }
}
