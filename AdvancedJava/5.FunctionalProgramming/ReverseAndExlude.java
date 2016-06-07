import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseAndExlude {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.asList(input);
        List<Integer> numberList = Arrays.stream(input).boxed().collect(Collectors.toList());
        Integer n = Integer.parseInt(bf.readLine());
        Collections.reverse(numberList);
        numberList.stream()
                .filter(i -> i % n != 0)
                .forEach(i -> System.out.print(i + " "));
        bf.close();
    }
}
