import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateParty {
    private static Predicate<String> predicateToUse;
    private static ArrayList<String> guestsList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        guestsList = new ArrayList<String>(Arrays.asList(bf.readLine().split("\\s+")));
        String line = "";
        while (!(line = bf.readLine()).equals("Party!")) {
            String[] input = line.split("\\s+");
            String command = input[0];
            String option = input[1];
            String var = input[2];
            Predicate<String> lengthPredicate = (string) -> string.length() == Integer.parseInt(var);
            Predicate<String> startsWithPredicate = (string) -> string.startsWith(var);
            Predicate<String> endsWithPredicate = (string) -> string.endsWith(var);
            switch (option) {
                case "Length":
                    predicateToUse = lengthPredicate;
                    break;
                case "StartsWith":
                    predicateToUse = startsWithPredicate;
                    break;
                case "EndsWith":
                    predicateToUse = endsWithPredicate;
                    break;
            }
            switch (command) {
                case "Remove":
                    removeGuest();
                    break;
                case "Double":
                    addGuest();
                    break;
            }
        }

        printGuestList();
    }

    private static void printGuestList() {
        if (guestsList.size() > 0) {
            String joined = String.join(", ", guestsList);
            System.out.println(joined + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static void removeGuest() {
        guestsList.removeIf(predicateToUse);
    }

    private static void addGuest() {
        ArrayList<String> guestsToAdd = new ArrayList<>();
        for (String guest : guestsList) {
            if (predicateToUse.test(guest)) {
                guestsToAdd.add(guest);
            }
            guestsToAdd.add(guest);
        }
        guestsList = guestsToAdd;
    }
}