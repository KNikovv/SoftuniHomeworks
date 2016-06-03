import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        long n = sc.nextLong();
        sc.nextLine();
        for(int i = 0 ; i<n ; i ++){
            set.add(sc.nextLine());
        }
        for (String user : set) {
            System.out.println(user);
        }
    }
}
