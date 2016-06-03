import java.text.Collator;
import java.util.*;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        HashSet<String> set = new HashSet<>();
        String [] split = input.split("[, \\.!?]+");
        for(int i = 0 ;i < split.length;i++){
            String current = split[i];

            String firstpart = "";
            String secondpart = "";
            for(int j = 0; j< current.length()/2;j++){
                firstpart += current.charAt(j);
            }
            for(int j = current.length()-1;
                current.length()%2==1 ? j> current.length()/2 : j>=current.length()/2;
                j--){
                secondpart += current.charAt(j);
            }
            if (firstpart.equals(secondpart)) {
                set.add(current);
            }

        }
        List<String> asList = new ArrayList<>(set);
        Collator collator = Collator.getInstance(Locale.UK);
        Collections.sort(asList,collator);
        System.out.println(asList);
    }
}