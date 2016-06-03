import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] arr = scan.nextLine().split("[\\t\\s ]+");
        int firstN = Integer.parseInt(arr[0]);
        double secondN = Double.parseDouble(arr[1]);
        double thirdN = Double.parseDouble(arr[2]);
        String aBinary = Integer.toString(firstN, 2);
        if(aBinary.length()>10){
            aBinary =aBinary.substring(0,10);
        }

        System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", firstN, Integer.parseInt(aBinary), secondN, thirdN);
    }
}