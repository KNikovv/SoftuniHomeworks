import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.nextLine();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            for(String s : input){
                set.add(s);
            }
        }
        for(String compound : set){
            System.out.print(compound + " ");
        }
    }
}

