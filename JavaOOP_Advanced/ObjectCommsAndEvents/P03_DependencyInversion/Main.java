package P03_DependencyInversion;

import P03_DependencyInversion.strategies.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        Calculator calculator = new PrimitiveCalculator();
        try {
            String line;
            while (!(line = buffReader.readLine().toLowerCase()).equals("end")) {
                String[] params = line.split("\\s+");
                switch (params[0]) {
                    case "mode":
                        try {
                            Strategy strategy = getNewStrategy(params[1]);
                            calculator.changeStrategy(strategy);
                        } catch (IllegalStateException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    default:
                        int firstOperand = Integer.valueOf(params[0]);
                        int secondOperand = Integer.valueOf(params[1]);
                        System.out.println(calculator.performCalculation(firstOperand, secondOperand));
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Strategy getNewStrategy(String operator) {

        switch (operator) {
            case "+":
                return new AdditionStrategy();
            case "-":
                return new SubtractionStrategy();
            case "*":
                return new MultiplyStrategy();
            case "/":
                return new DivideStrategy();
            default:
                throw new IllegalStateException("No such strategy");
        }
    }
}
