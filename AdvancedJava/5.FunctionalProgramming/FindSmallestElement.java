import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindSmallestElement {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(bf.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(findMinElementsIndex.apply(numberArray));
    }
    private static Function<int[],Integer> findMinElementsIndex = array -> {
        int minimum = Integer.MAX_VALUE;
        int indexOfMin = 0 ;
        for(int i = 0;i<array.length;i++){
            int currentNumber = array[i];
            if(minimum>=currentNumber){
                minimum = currentNumber;
                indexOfMin = i;
            }
        }
        return  indexOfMin;
    };
}
