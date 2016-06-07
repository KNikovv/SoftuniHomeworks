import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AppliedAritmethics {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = "";
        while (!(command = bf.readLine()).equals("end")) {
            switch (command) {
                case "add":
                    numberArray = Arrays.stream(numberArray).map(i -> i + 1).toArray();
                    break;
                case "subtract":
                    numberArray = Arrays.stream(numberArray).map(i -> i - 1).toArray();
                    break;
                case "multiply":
                    numberArray = Arrays.stream(numberArray).map(i -> i * 2).toArray();
                    break;
                case "print":
                    Arrays.stream(numberArray).forEach(i -> System.out.print(i + " "));
                    System.out.println();
                    break;
            }
        }
        bf.close();
    }
}
