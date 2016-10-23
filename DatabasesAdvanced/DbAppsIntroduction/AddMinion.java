import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USER = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String minionLine = scanner.nextLine();
        String villainLine = scanner.nextLine();

        String minionRegex = "Minion:\\s+(\\w+)\\s+(\\d+)\\s+(\\w+)";
        Pattern pattern = Pattern.compile(minionRegex);
        Matcher minionMatcher = pattern.matcher(minionLine);
        minionMatcher.find();

        String minionName = minionMatcher.group(1);
        Integer minionAge = Integer.valueOf(minionMatcher.group(2));
        String minionTown = minionMatcher.group(3);
        String villainName = villainLine.substring(villainLine.indexOf(": ") + 1).trim();

        StringBuilder result = new StringBuilder();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement();
        ) {
            insertIfNotPresent(minionTown, result, statement,
                    "SELECT * FROM towns WHERE name = '%s'",
                    "INSERT INTO towns(name) VALUES('%s')",
                    String.format("Town %s was added to the database\n", minionTown));
            insertIfNotPresent(villainName, result, statement,
                    "SELECT * FROM villains WHERE villain_name = '%s'",
                    "INSERT INTO villains(villain_name,evillness_factor)" +
                    " VALUES('%s','Evil')",
                    String.format("Villain %s was added to the database\n", villainName));

            String townIdQ = String.format("SELECT town_id FROM towns WHERE name = '%s'", minionTown);
            ResultSet selectQuery = statement.executeQuery(townIdQ);
            int town_id = selectQuery.next() ? selectQuery.getInt("town_id") : 0;
            String insertMinion = String.format("INSERT INTO minions(name,age,town_id)" +
                    " VALUES ('%s',%d,%d) ", minionName, minionAge, town_id);
            statement.execute(insertMinion);
            String minionIdQuery =
                    String.format("SELECT minion_id FROM minions WHERE name = '%s'", minionName);
            String villainIdQuery =
                    String.format("SELECT villain_id FROM villains WHERE villain_name = '%s'", villainName);
             selectQuery = statement.executeQuery(minionIdQuery);
            int minionId = selectQuery.next() ? selectQuery.getInt("minion_id") : 0;
            //
             selectQuery = statement.executeQuery(villainIdQuery);
            //
            int villainId = selectQuery.next() ? selectQuery.getInt("villain_id") : 0;

            if (minionId != 0 && villainId != 0) {
                String insertRelation = String.format("INSERT INTO villains_minions(villain_id,minion_id)" +
                        "VALUES (%d,%d)", villainId, minionId);
                statement.execute(insertRelation);

                result.append(String.format(
                        "Succesfully added %s to be minion of %s\n", minionName, villainName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }

    private static void insertIfNotPresent(String minionTown,
                                           StringBuilder result,
                                           Statement statement,
                                           String select,
                                           String insert,
                                           String output) throws SQLException {
        String query = String.format(select, minionTown);
        ResultSet resultSet = statement.executeQuery(query);
        if (!resultSet.next()) {
            String insertTown = String.format(insert, minionTown);
            statement.execute(insertTown);
            result.append(output);
        }
    }
}
