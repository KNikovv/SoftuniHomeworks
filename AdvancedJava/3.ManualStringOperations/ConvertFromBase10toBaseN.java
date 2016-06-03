import java.math.BigInteger;
import java.util.Scanner;

public class ConvertFromBase10toBaseN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        BigInteger base = new BigInteger(arr[0]);
        BigInteger num = new BigInteger(arr[1]);
        StringBuilder result = new StringBuilder();
        while(num.compareTo(BigInteger.ZERO)==1){
            result.append(num.remainder(base));
            num = num.divide(base);
        }
        System.out.println(result.reverse().toString());
    }
}
