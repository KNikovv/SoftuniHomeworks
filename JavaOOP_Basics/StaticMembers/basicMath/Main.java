package basicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = bf.readLine()).equals("End")) {
            String[] input = line.split("\\s+");
            String command = input[0];
            double value1 = Double.parseDouble(input[1]);
            double value2 = Double.parseDouble(input[2]);
            switch (command) {
                case "Sum":
                    System.out.printf("%.2f\n",(MathUtil.sum(value1, value2)));
                    break;
                case "Subtract":
                    System.out.printf("%.2f\n",(MathUtil.subtract(value1, value2)));
                    break;
                case "Multiply":
                    System.out.printf("%.2f\n",(MathUtil.multiply(value1, value2)));
                    break;
                case "Divide":
                    System.out.printf("%.2f\n",(MathUtil.divide(value1, value2)));
                    break;
                case "Percentage":
                    System.out.printf("%.2f\n",(MathUtil.percentage(value1, value2)));
                    break;
            }
        }
    }
}
