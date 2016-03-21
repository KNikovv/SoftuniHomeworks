
import java.util.Scanner;

/**
 * Created by kaloy on 3/9/2016.
 */
public class CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = sc.nextLine().split("[\\W\\d]+");;
        String word = sc.nextLine();
        int count = 0;

        for (int i=0; i<text.length; i++) {
            if (text[i].equalsIgnoreCase(word)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
