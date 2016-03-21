import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kaloy on 3/9/2016.
 */
public class LongestIncreasingSequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strArray = sc.nextLine().split(" ");
        List<Integer> currentList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            int num = Integer.parseInt(strArray[i]);
            currentList.add(num);
            if (i == strArray.length - 1) {
                if (currentList.size() < 1) {
                    currentList.add(num);
                }
            } else {
                int nextnum = Integer.parseInt((strArray[i + 1]));
                if (num < nextnum) {
                    while (num < nextnum) {
                        if (i == strArray.length - 2) {
                            currentList.add(nextnum);
                            i++;
                            break;
                        }
                        i++;
                        currentList.add(nextnum);
                        num = Integer.parseInt(strArray[i]);
                        nextnum = Integer.parseInt(strArray[i + 1]);
                    }
                }
            }
            if (currentList.size() > maxList.size()) {
                maxList.clear();
                maxList.addAll(currentList);
            }
            System.out.println(String.join(" ", currentList.toString()));
            currentList.clear();
        }
        System.out.print("Longest:");
        for (Integer integer : maxList) {
            System.out.print(integer.toString() + " ");
        }
    }
}
