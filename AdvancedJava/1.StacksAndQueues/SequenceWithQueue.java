import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        ArrayDeque<Long>    tempQueue = new ArrayDeque<>();
        ArrayDeque<Long>  resultQueue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        long first = sc.nextLong();
        tempQueue.add(first);
        resultQueue.add(first);
        while (true){
            long head = tempQueue.peek();
            tempQueue.add(head+ 1);
            tempQueue.add(2*head + 1);
            tempQueue.add(head + 2);
            tempQueue.remove();

            resultQueue.add(head+1);
            if(resultQueue.size()==50){
                break;
            }
            resultQueue.add(2*head + 1);
            resultQueue.add(head + 2);
        }
        for(Long num : resultQueue){
            System.out.print(num + " ");
        }
    }
}
