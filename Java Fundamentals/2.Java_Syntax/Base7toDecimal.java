import java.util.Scanner;


public class Base7toDecimal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberInBase7 = Integer.parseInt(scanner.nextLine(), 7);
        String numberInDecimal = Integer.toString(numberInBase7, 10);

        System.out.println(numberInDecimal);
    }
}
