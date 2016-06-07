import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] stringArray = bf.readLine().split("\\s+");
        Consumer<String> stringConsumer = System.out::println;
        Arrays.stream(stringArray).forEach(stringConsumer);

        bf.close();
    }
}
