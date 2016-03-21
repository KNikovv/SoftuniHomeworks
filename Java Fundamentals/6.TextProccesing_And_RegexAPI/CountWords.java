import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s*[a-zA-Z]+\\s*");
        System.out.println(input.length-1);
    }
}
