import java.math.BigInteger;
import java.util.Scanner;

public class ConvertFromBaseNtoBase10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        BigInteger base = new BigInteger(arr[0]);
        BigInteger num = new BigInteger(arr[1]);
        BigInteger result = BigInteger.ZERO;
        int index = 0;
        while(num.compareTo(BigInteger.ZERO)==1){
            result = result.add(num.remainder(BigInteger.valueOf(10)).multiply(base.pow(index)));
            num = num.divide(BigInteger.valueOf(10));
            index++;
        }
        System.out.println(result);
    }
}