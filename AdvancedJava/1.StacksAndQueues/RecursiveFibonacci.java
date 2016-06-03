import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacci {
    private static HashMap<Integer, Long> memoMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        long fibonacciNumber = getFibonacii(number);
        System.out.println(fibonacciNumber);
    }

    private static long getFibonacii(int n) {
        if (n <= 1) {
            return 1;
        }
        if (!memoMap.containsKey(n)) {
            memoMap.put(n, getFibonacii(n-1)+getFibonacii(n-2));
        }
        return memoMap.get(n);
    }
}

