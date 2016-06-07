import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> sirAppender = (x)-> System.out.println("Sir " + x);
        String[] stringArray = bf.readLine().split("\\s+");
        Arrays.stream(stringArray).forEach(sirAppender);
        bf.close();
    }
}
