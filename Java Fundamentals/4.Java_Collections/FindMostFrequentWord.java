import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by kaloy on 3/10/2016.
 */
public class FindMostFrequentWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\W+");
        List<String> list1 = new ArrayList<>();
        List<String> mostFreqlist = new ArrayList<>();
        int mostfrequent = 1;
        for (int i = 0; i < words.length - 1; i++) {
            int count = 0;
            String word1 = words[i];
            if (mostFreqlist.contains(word1)) {
                continue;
            }
            list1.add(word1.toLowerCase());
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if (word1.equalsIgnoreCase(word2)) {
                    count++;
                    list1.add(word1.toLowerCase());
                }
            }
            if (count >= mostfrequent) {
                if (count == mostfrequent) {
                    mostFreqlist.addAll(list1);
                } else {
                    mostfrequent = count;
                    mostFreqlist.clear();
                    mostFreqlist.addAll(list1);
                }
            }
            list1.clear();
        }
        Collections.sort(mostFreqlist);
        for (int i = 0; i < mostFreqlist.size()-1; i++) {
            String word = mostFreqlist.get(i);
            int count = 1;
            if(mostFreqlist.size()==1){
                System.out.println(word + " -> " + count + " times");break;
            }
            String nextword=mostFreqlist.get(i+1);
            while (word.equals(nextword)) {
                count++;
                if(i==mostFreqlist.size()-2){
                    break;
                }
                i++;
                nextword = mostFreqlist.get(i+1);
            }
            System.out.println(word + " -> " + count + " times");
        }
    }
}

