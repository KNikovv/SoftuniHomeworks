import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] banList = sc.nextLine().split(", ");
        String text = sc.nextLine();
        for (String ban : banList) {
            StringBuilder asteriskBuilder = new StringBuilder();
            for (int i = 0; i < ban.length(); i++) {
                asteriskBuilder.append("*");
            }
            text = text.replaceAll(ban, asteriskBuilder.toString());
        }
        System.out.println(text);
    }
}