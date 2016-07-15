package genericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(buffReader.readLine());
        GenericBox<Integer> genericBox = new GenericBox<>();
        for (int i = 0; i < n; i++) {
            Integer number = Integer.valueOf(buffReader.readLine());
            genericBox.addItem(number);
        }

        System.out.println(genericBox);
    }

}
