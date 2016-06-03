import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int maxElement = Integer.MIN_VALUE;
        while (n > 0) {
            String[] line = sc.nextLine().split(" ");
            int command = Integer.parseInt(line[0]);

            switch (command) {
                case 1:
                    int number = Integer.parseInt(line[1]);
                    if (number > maxElement) {
                        maxElement = number;
                        maxStack.push(maxElement);
                    }
                    stack.push(number);
                    break;
                case 2:
                    if (maxStack.contains(stack.peek())) {
                        maxStack.pop();
                        if(maxStack.size()>0) {
                            maxElement = maxStack.peek();
                        }else{
                            maxElement = Integer.MIN_VALUE;
                        }
                    }
                    stack.pop();
                    break;
                case 3:
                    System.out.println(maxStack.peek());
                    break;
            }
            n--;
        }
    }
}