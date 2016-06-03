import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] firstLine = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numbers = firstLine[0];
        int popNumbers = firstLine[1];
        int elementToFind = firstLine[2];
        int[] secondLine = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> queue = new LinkedList<>();
        for (int num : secondLine) {
            queue.add(num);
        }
        for (int i = 0 ;i < popNumbers;i++){
            queue.poll();
        }
        if(queue.contains(elementToFind)){
            System.out.println(true);
        }else{
            if(!queue.isEmpty()) {
                int min = queue.peek();
                for (int num : queue) {
                    if (num < min) {
                        min = num;
                    }
                }
                System.out.println(min);
            }else{
                System.out.println(0);
            }
        }
    }
}
