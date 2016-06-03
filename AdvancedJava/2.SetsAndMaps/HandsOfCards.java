import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        while (!(input = sc.nextLine()).equals("JOKER")) {

            String[] split = input.split(": ");
            Matcher matcher = Pattern.compile("^([^:]+)").matcher(split[0]);
            if (matcher.find()) {
                String name = matcher.group(1);
                String[] cardInfo = split[1].split(", ");
                if (!map.containsKey(name)) {
                    map.put(name, new ArrayList<>());
                }
                for (int i = 0; i < cardInfo.length; i++) {
                    ArrayList<String> cards = map.get(name);
                    if (!cards.contains(cardInfo[i])) {
                        map.get(name).add(cardInfo[i]);
                    }
                }
            }
        }
        map.entrySet().stream().forEach(player -> {
            ArrayList<String> cards = player.getValue();
            long total = getTotalValue(cards);
            System.out.format("%s: %d\n", player.getKey(), total);
        });

    }

    private static long getTotalValue(ArrayList<String> cards) {
        long total = 0;
        for (int i = 0; i < cards.size(); i++) {
            String current = cards.get(i);
            String face = current.substring(0, current.length() - 1);
            Character suit = current.charAt(current.length() - 1);
            long faceValue = 0;
            switch (face) {
                case "J":
                    faceValue = 11;
                    break;
                case "Q":
                    faceValue = 12;
                    break;
                case "K":
                    faceValue = 13;
                    break;
                case "A":
                    faceValue = 14;
                    break;
                default:
                    faceValue = Long.parseLong(face);
                    break;
            }
            switch (suit) {
                case 'S':
                    faceValue *= 4;
                    break;
                case 'H':
                    faceValue *= 3;
                    break;
                case 'D':
                    faceValue *= 2;
                    break;
            }
            total += faceValue;
        }
        return total;
    }
}