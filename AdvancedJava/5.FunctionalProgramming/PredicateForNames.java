import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        String[] names = bf.readLine().split(" ");
        Predicate<String> predicate = i -> i.length()<=number;
        Arrays.stream(names).filter(predicate).forEach(System.out::println);
        bf.close();
    }

}
