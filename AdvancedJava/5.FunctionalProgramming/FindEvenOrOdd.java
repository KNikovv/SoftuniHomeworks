import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] bounds = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = IntStream.range(bounds[0], bounds[1] + 1).map(i -> i++).toArray();
        String command = sc.nextLine();
        IntPredicate isEven = (i) -> i % 2 == 0;
        IntPredicate isOdd = (i) -> i % 2 != 0;
        switch (command) {
            case "odd":
                Arrays.stream(arr).filter(isOdd).forEach(element -> System.out.print(element + " "));
                break;
            case "even":
                Arrays.stream(arr).filter(isEven).forEach(element -> System.out.print(element + " "));
                break;
        }
    }
}
