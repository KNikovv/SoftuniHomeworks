import java.util.Scanner;

/**
 * Created by kaloy on 3/10/2016.
 */
public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextInt();
        long l=1;
        calculateFactorial(n,l);
    }
    public static void calculateFactorial(long n, long l){
        if(n<1){
            System.out.println(l);
            return;
        }
        l *=n;
        calculateFactorial(n - 1,l);

    }
}
