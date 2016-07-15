package genericCountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(buffReader.readLine());
        List<Double> stringList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stringList.add(Double.parseDouble(buffReader.readLine()));
        }

        Double toCompare = Double.valueOf(buffReader.readLine());

        int count = returnCount(stringList,toCompare);

        System.out.println(count);
    }

    private static <T extends Comparable<T>> int returnCount(List<T> list, T element) {
        int count = 0;

        for (T listElement : list) {
            if (listElement.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}
