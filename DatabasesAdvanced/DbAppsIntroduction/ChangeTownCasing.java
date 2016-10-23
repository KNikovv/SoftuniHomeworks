import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ChangeTownCasing {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String countryName = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement();
        ) {
            String getTownsQ =
                    String.format("SELECT name FROM towns WHERE country_name = '%s'", countryName);
            ResultSet towns = statement.executeQuery(getTownsQ);
            List<String> townsChanged = new LinkedList<>();
            while (towns.next()) {
                String townName = towns.getString("name");
                if (!isUppercase(townName)) {
                    townsChanged.add(townName.toUpperCase());
                }
            }

            String updateQ = String.format("UPDATE towns SET name = UPPER(name) " +
                    "WHERE country_name = '%s'", countryName);
            statement.execute(updateQ);

            stringBuilder.append(townsChanged.isEmpty() ?
                    "No town names were affected." :
                    String.format(
                            "%d town names were affected.\n%s\n", townsChanged.size(), townsChanged));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
    }

    private static boolean isUppercase(String text) {
        for (char ch : text.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }
}
