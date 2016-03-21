import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kaloy on 3/10/2016.
 */
public class sortArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\W+");
        String order = scan.nextLine();
        int[] intarray = new int[input.length];
        for (int i = 0; i < intarray.length; i++) {
            intarray[i] = Integer.parseInt(input[i]);
        }
        if (order.equals("Ascending")){
            Arrays.stream(input)
                    .sorted((e1, e2) -> Integer.compare(Integer.parseInt(e1), Integer.parseInt(e2)))
                    .forEach(e -> System.out.print(e + " "));
        }else{
            Arrays.stream(input)
                    .sorted((e1, e2) -> Integer.compare(Integer.parseInt(e2), Integer.parseInt(e1)))
                    .forEach(e -> System.out.print(e + " "));
        }
    }
}
