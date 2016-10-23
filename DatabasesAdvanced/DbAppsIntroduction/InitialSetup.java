import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class InitialSetup {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String password = "1234";
    private static final String dropDb = "DROP DATABASE IF EXISTS minions_db";

    public static void main(String[] args) {


        HashMap<String,String[]> villainsMinions = new HashMap<>();
        villainsMinions.put("Gru",new String[]{"Pesho","Kondio","Mohamed","Abdul"});
        villainsMinions.put("Ahmed",new String[]{"Rahman","Kazan","Mamut","Orhan"});
        villainsMinions.put("Penko",new String[]{"Axel","Rasputin","Minko"});
        villainsMinions.put("Richie",new String[]{"Kuncho","Volen"});
        villainsMinions.put("Rambo",new String[]{"Pepsi"});
        String[] towns = new String[] {"Sofia","Plovdiv","Varna","Bourgas","Ruse"};

        try (
                Connection connection = DriverManager.getConnection(URL, USER, password);
                Statement statement = connection.createStatement()) {
            statement.execute(dropDb);
            String createDb = "CREATE DATABASE minions_db;";
            statement.execute(createDb);
            createDb = "USE minions_db";
            statement.execute(createDb);
            String createTable = "CREATE TABLE minions(" +
                    "minion_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "age INT ," +
                    "town_id INT);";
            statement.execute(createTable);
            //
            createTable = "CREATE TABLE towns(" +
                    "town_id INT AUTO_INCREMENT PRIMARY KEY ," +
                    "name VARCHAR(50)," +
                    "country_name VARCHAR(50))";
            statement.execute(createTable);
            createTable = "CREATE TABLE villains(" +
                    "villain_id INT AUTO_INCREMENT PRIMARY KEY ," +
                    "villain_name VARCHAR(50)," +
                    "evillness_factor ENUM('GOOD','BAD','EVIL','SUPEREVIL'))";
            statement.execute(createTable);

            createTable = "CREATE TABLE villains_minions(" +
                    "villain_id INT," +
                    "minion_id INT," +
                    "PRIMARY KEY (villain_id,minion_id)," +
                    "CONSTRAINT fk_villains_minions_villains FOREIGN KEY(villain_id) REFERENCES " +
                    "villains(villain_id)," +
                    "CONSTRAINT fk_villains_minions_minions FOREIGN KEY(minion_id) REFERENCES " +
                    "minions(minion_id));";
            statement.execute(createTable);

            int age = 5;
            for (String town : towns) {
                String insert = String.format("INSERT INTO towns(name,country_name)" +
                        " VALUES('%s','%s')",town,"Bulgaria");
                statement.execute(insert);
            }

            int townId = 1;
            for (Map.Entry<String, String[]> entry : villainsMinions.entrySet()) {
                String villainName = entry.getKey();
                String[] minions = entry.getValue();
                String insert =
                        String.format("INSERT INTO villains(villain_name,evillness_factor) " +
                        "VALUES('%s','GOOD')",villainName);
                for (String minion : minions) {

                String insert2 = String.format("INSERT INTO minions(name,age,town_id) " +
                                "VALUES('%s',%d,%d)",
                        minion,age,townId);
                    statement.execute(insert2);
                }
                statement.execute(insert);
                townId++;
                age += 4;
            }


            int villain_id = 1;
            for(int minion_id = 1 ; minion_id <= 14 ; minion_id++) {
                if(minion_id==5 || minion_id == 9 || minion_id==12 || minion_id==14) {
                    villain_id++;
                }
                String insert =
                        String.format("INSERT INTO villains_minions(villain_id,minion_id) " +
                                "VALUES(%d,%d)",villain_id,minion_id);
                statement.execute(insert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
