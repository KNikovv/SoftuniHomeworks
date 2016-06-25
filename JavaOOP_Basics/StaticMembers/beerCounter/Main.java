package beerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        BeerCounter beerCounter = new BeerCounter();
        while (!(line = bf.readLine()).equals("End")) {
            Integer[] beersInput = Arrays.stream(line.split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer beersToAdd = beersInput[0];
            Integer beersToDrink = beersInput[1];
            beerCounter.addBeer(beersToAdd);
            beerCounter.drinkBeer(beersToDrink);
         }
        System.out.println(BeerCounter.beerInStock + " " + BeerCounter.beerDrank);
        System.out.println(1500%99);
    }
}
