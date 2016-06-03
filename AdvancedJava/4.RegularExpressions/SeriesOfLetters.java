import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        bf.close();
        System.out.println(line.replaceAll("([a-zA-Z])(\\1+)", "$1"));
    }
}
