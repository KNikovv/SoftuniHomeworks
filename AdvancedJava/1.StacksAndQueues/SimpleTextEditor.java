import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> deque = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.nextLine());
        while (n > 0) {
            String[] input = sc.nextLine().split(" ");
            String command = input[0];
            switch (command) {
                case "1":
                    deque.push(sb.toString());
                    sb.append(input[1]);
                    break;
                case "2":
                    deque.push(sb.toString());
                    int length = Integer.parseInt(input[1]);
                    sb.delete(sb.length()-length,sb.length());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1])-1;
                    System.out.println(sb.charAt(index));
                    break;
                case "4":
                    sb.delete(0,sb.length());
                    sb.append(deque.pop());
                    break;
            }
            n--;
        }
    }
}