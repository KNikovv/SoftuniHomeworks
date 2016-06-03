import java.util.Scanner;

public class CountSubstringOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().toLowerCase();
        String word = sc.nextLine().toLowerCase();
        int count = countStringOccurrences(text, word);
        System.out.println(count);
    }

    public static int countStringOccurrences(String text, String word) {

        int count = 0;
        int i = 0;
        while ((i = text.indexOf(word, i)) != -1) {
            i++;
            count++;
        }
        return count;
    }
}