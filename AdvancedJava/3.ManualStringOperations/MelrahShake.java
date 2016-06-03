
import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String pattern = scan.nextLine();

        while (true) {
            if (pattern.equals("") || countStringOccurrences(input,pattern)<2) {
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }
            StringBuilder sb = new StringBuilder(input);
            int start = sb.indexOf(pattern);
            int end = pattern.length();
            sb.delete(start, start + end);
            start = sb.lastIndexOf(pattern);
            sb.delete(start, start + end);
            int index = pattern.length()/2;
            pattern = pattern.substring(0,index) + pattern.substring(index+1 , pattern.length());
            input = sb.toString();
            System.out.println("Shaked it.");
        }
    }

    private static int countStringOccurrences(String text, String word) {

        int count = 0;
        int i = 0;
        while ((i = text.indexOf(word, i)) != -1) {
            i++;
            count++;
        }
        return count;
    }
}
