import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] firstLine = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numbers = firstLine[0];
        int popNumbers = firstLine[1];
        int elementToFind = firstLine[2];
        int[] secondLine = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numbers-popNumbers;i++){
            stack.push(secondLine[i]);
        }
        if(stack.contains(elementToFind)){
            System.out.println(true);
        }else{
            if(!stack.isEmpty()) {
                int min = stack.peek();
                for (int num : stack) {
                    if (num < min) {
                        num = min;
                    }
                }
                System.out.println(min);
            }else{
                System.out.println(0);
            }
        }
    }
}
