import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunc {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int[] arr = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMinElement.apply(arr));
        bf.close();
    }

    private static Function<int[],Integer> findMinElement = array -> {
        int minimum = 0;
        if(array.length>0) {
            minimum= array[0];
            for (Integer num : array) {
                if (minimum > num) {
                    minimum = num;
                }
            }
        }else{
            minimum=0;
        }
        return  minimum;
    };
}