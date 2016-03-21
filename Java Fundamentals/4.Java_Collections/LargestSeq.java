import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kaloy on 3/7/2016.
 */
public class LargestSeq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        longestSequence(input);
    }

    public static void longestSequence(String[] input) {
        int longest = 0;
        int length = 1;
        List<String> currentlist = new ArrayList<>();
        List<String> maxlist = new ArrayList<>();
        maxlist.add(input[0]);
        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1) {
                break;
            }
            if (input[i].equals(input[i + 1])) {

                while (input[i].equals(input[i + 1])) {
                    if (i == input.length - 2) {
                        if (currentlist.size() == 0) {
                            currentlist.add(input[i]);
                        }
                        currentlist.add(input[i + 1]);
                        length++;
                        if(i==input.length-2){
                            break;
                        }
                        i++;
                        continue;
                    }
                    length++;
                    currentlist.add(input[i]);
                    if (currentlist.size() == 1) {
                        currentlist.add(input[i + 1]);
                    }
                    i++;
                }
            } else {
                length = 0;
                currentlist.clear();
            }
            if (length > longest) {
                longest = length;
                length=0;
                maxlist.clear();
                maxlist.addAll(currentlist);
                currentlist.clear();
            }
            else{
                currentlist.clear();
                length=0;
            }
        }
        currentlist.clear();
        System.out.println(String.join(" ", maxlist));
    }
}
