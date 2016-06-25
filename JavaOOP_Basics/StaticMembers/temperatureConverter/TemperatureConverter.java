package temperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while (!(line = bf.readLine()).equals("End")) {
            String[] input = line.split("\\s+");
            Integer temperature = Integer.parseInt(input[0]);
            String unit = input[1];
            double degrees = 0;
            switch (unit) {
                case "Celsius":
                    degrees = convertToFahrenheit(temperature);
                    System.out.printf("%.2f Fahrenheit\n",degrees);
                    break;
                case "Fahrenheit":
                    degrees = convertToCelsius(temperature);
                    System.out.printf("%.2f Celsius\n",degrees);
                    break;
            }
        }
    }

    private static double convertToFahrenheit(int celsius) {
        double temp = celsius*9;
        temp /= 5;
        temp += 32;
        return temp;
    }

    private static double convertToCelsius(int fahrenheit) {
        double temp = fahrenheit - 32;
        temp *=5;
        temp /=9;
        return temp;
    }
}
