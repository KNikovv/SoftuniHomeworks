import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Stack<Long> stack = new Stack<>();
        stack.push(1L);
        stack.push(1L);
        while(n>1){
            long first = stack.peek();
            stack.pop();
            long second = stack.peek();
            long fib = first + second;
            stack.push(fib);
            stack.push(second);
            n--;
        }
        stack.pop();
        System.out.println(stack.peek());
    }
}