import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaloy on 3/2/2016.
 */

public class SaveArrayList {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        doubles.add(3.55);
        doubles.add(2.12);
        doubles.add(3.44);
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/doubles.list"))) {

            for (double item : doubles) {
                output.writeDouble(item);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("resources/doubles.list"))) {
            InputStreamReader reader = new InputStreamReader(input);
            while (reader != null) {
                System.out.println(input.readDouble());
            }

        } catch (IOException ex) {

        }
    }
}
