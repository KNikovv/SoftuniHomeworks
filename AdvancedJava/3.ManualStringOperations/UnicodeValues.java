import java.util.Scanner;

public class UnicodeValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for(int i = 0 ;i<input.length();i++){
            System.out.print(toUnicode(input.charAt(i)));
        }
    }
    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}
