import java.util.HashMap;
import java.util.Scanner;

public class MagicExchangableWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = scan.nextLine().split("[\\t\\s ]+");
        String first = arr[0];
        String second = arr[1];
        System.out.println(areEqual(first, second));
    }

    private static boolean areEqual(String a, String b) {
        int end = Math.max(a.length(), b.length());
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < end; i++) {
            if (i > b.length() - 1) {
                if (!map.containsKey(a.charAt(i))) {
                    return false;
                } else {
                    continue;
                }
            }
            if (i > a.length() - 1) {
                if (!map.containsValue(b.charAt(i))) {
                    return false;
                } else {
                    continue;
                }
            }
            char firstChar = a.charAt(i);
            char secondChar = b.charAt(i);
            if (!map.containsKey(firstChar)) {
                if(map.containsValue(secondChar)){
                    return false;
                }else {
                    map.put(firstChar, secondChar);
                }
            } else {
                if (!map.get(firstChar).equals(secondChar)) {
                    return false;
                }
            }
        }

        return true;
    }
}