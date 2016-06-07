import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int upperBound = Integer.parseInt(bf.readLine());
        int[] allNumbers = IntStream.range(1, upperBound + 1).map(i -> i++).toArray();
        int[] dividers = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
        for (int div : dividers) {
            Predicate<Integer> predicate = integer -> integer % div == 0;
            allNumbers = Arrays.stream(allNumbers).filter(predicate::test).toArray();
        }
        Arrays.stream(allNumbers).forEach(num -> System.out.print(num + " "));
        bf.close();
    }

}
