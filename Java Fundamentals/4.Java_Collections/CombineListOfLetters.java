import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kaloy on 3/9/2016.
 */
public class CombineListOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstSentence = scan.nextLine().split(" ");
        String[] secondSentence = scan.nextLine().split(" ");
        ArrayList<Character> firstList = new ArrayList<>();
        ArrayList<Character> secondList = new ArrayList<>();
        getLetters(firstSentence, firstList);
        getLetters(secondSentence, secondList);
        ArrayList<Character> result = new ArrayList<>(firstList);
        for (Character character : secondList) {
            if(!(firstList.contains(character))){
                result.add(character);
            }
        }
        for (Character character: result){
            System.out.print(character+ " ");
        }
    }

    public static void getLetters(String[] str, ArrayList<Character> list) {
        for (String s : str) {
            list.add(s.charAt(0));
        }
    }
}
