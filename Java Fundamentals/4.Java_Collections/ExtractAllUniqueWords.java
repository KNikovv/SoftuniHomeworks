import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kaloy on 3/10/2016.
 */
public class ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] words= scan.nextLine().split("\\W+");
        Set<String> strings = new HashSet<>();
        for (String word : words) {
            strings.add(word.toLowerCase());
        }
        strings.stream().sorted().forEach(string -> System.out.print(string + " "));
    }
}
