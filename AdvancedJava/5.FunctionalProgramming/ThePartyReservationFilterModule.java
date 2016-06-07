import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Predicate<String>> predicates = new HashMap<>();
        String[] names = bf.readLine().split("\\s+");
        String line = "";
        while (!(line = bf.readLine()).equals("Print")) {
            String[] input = line.split(";");
            String command = input[0];
            String filterType = input[1];
            String filterParam = input[2];

            Predicate<String> currentPredicate = getPredicate(filterType, filterParam);
            switch (command) {
                case "Add filter":
                    predicates.put(filterType + filterParam, currentPredicate);
                    break;
                case "Remove filter":
                    predicates.remove(filterType + filterParam);
                    break;
            }
        }
        for (String name : names) {
            boolean isInvited = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(name)) {
                    isInvited = false;
                }
            }
            if (isInvited) {
                System.out.print(name + " ");
            }
        }

    }

    private static Predicate<String> getPredicate(String filter, String parameter) {
        switch (filter) {
            case "Starts with":
                return (string) -> string.startsWith(parameter);
            case "Ends with":
                return (string) -> string.endsWith(parameter);
            case "Contains":
                return (string) -> string.contains(parameter);
            case "Length":
                return (string) -> string.length() == Integer.parseInt(parameter);
            default:
                return null;
        }
    }
}
