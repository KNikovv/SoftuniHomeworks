import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by kaloy on 3/10/2016.
 */
public class FilterArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cards = scan.nextLine().split(" ");
        Arrays.stream(cards).filter(s -> s.length() > 3).forEach(over3-> System.out.print(over3 + " "));
    }
}