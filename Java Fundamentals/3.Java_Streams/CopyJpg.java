import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kaloy on 3/1/2016.
 */
public class CopyJpg {
    public static void main(String[] args) {


        try (FileInputStream reader = new FileInputStream("resources/softuni.png");
                FileOutputStream writer = new FileOutputStream("resources/softunicopy.png")) {
            int i;
            byte[] buffer = new byte[4096];
            while ((i = reader.read(buffer)) != -1) {
                writer.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
