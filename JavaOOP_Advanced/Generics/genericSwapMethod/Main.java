package genericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(buffReader.readLine());

        List<Integer> stringList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer line = Integer.valueOf(buffReader.readLine());
            stringList.add(line);
        }
        int[] indexes = Arrays.stream(buffReader.readLine().split("\\s")).mapToInt(Integer::valueOf).toArray();
        int indexOne = indexes[0];
        int indexTwo = indexes[1];

        GenericBox<Integer> genericBox = new GenericBox<>(stringList);
        genericBox.swapIndexes(indexOne, indexTwo);

        System.out.println(genericBox);

    }
}
