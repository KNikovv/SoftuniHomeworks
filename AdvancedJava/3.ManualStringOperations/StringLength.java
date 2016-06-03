import java.util.Scanner;

public class StringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);
        if(sb.length()>20){
            sb.delete(20,sb.length());
        }
        for(int i = sb.length();i<20;i++){
            sb.append("*");
        }
        System.out.println(sb.toString());
    }
}