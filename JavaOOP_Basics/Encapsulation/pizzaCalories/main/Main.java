package pizzaCalories.main;

import pizzaCalories.models.Dough;
import pizzaCalories.models.Pizza;
import pizzaCalories.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] firstLine = bf.readLine().split("\\s+");
            String[] secondLine = {""};
            if (firstLine[0].equals("Dough")) {
                String flourType = firstLine[1];
                String bakingTech = firstLine[2];
                double doughWeight = Double.valueOf(firstLine[3]);
                Dough dough = new Dough(flourType, bakingTech, doughWeight);
                secondLine = bf.readLine().split("\\s+");
                System.out.printf("%.2f\n",dough.calcDoughCalories());
            }
            if(secondLine[0].equals("END")){
                return;
            }else if(secondLine[0].equals("Topping")){
                String toppingType = secondLine[1];
                double toppingWeight = Double.valueOf(secondLine[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                System.out.printf("%.2f\n",topping.getToppingCalories());
                return;
            }
            String pizzaName = firstLine[1];
            int numberOfTOppings = Integer.valueOf(firstLine[2]);
            Pizza pizza = new Pizza(pizzaName, numberOfTOppings);

            String[] doughData = bf.readLine().split("\\s+");
            String flourType = doughData[1];
            String bakingTech = doughData[2];
            double doughWeight = Double.valueOf(doughData[3]);
            Dough dough = new Dough(flourType, bakingTech, doughWeight);

            pizza.addDough(dough);
            while (true) {
                String[] toppingData = bf.readLine().split("\\s+");
                if (toppingData[0].equals("END")) {
                    break;
                }
                String toppingType = toppingData[1];
                double toppingWeight = Double.valueOf(toppingData[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }
            pizza.calculateCalories();
            System.out.println(pizza);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
