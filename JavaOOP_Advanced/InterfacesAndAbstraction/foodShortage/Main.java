package foodShortage;

import foodShortage.factory.BuyerFactory;
import foodShortage.interfaces.Buyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        BuyerFactory buyerFactory = new BuyerFactory();
        List<Buyer> buyers = new ArrayList<>();

        int n = Integer.valueOf(buffReader.readLine());
        addBuyers(buffReader, buyerFactory, buyers, n);

        processBuying(buffReader, buyers);

        int totalFoodBought = getTotalFoodBought(buyers);
        System.out.println(totalFoodBought);
    }

    private static int getTotalFoodBought(List<Buyer> buyers) {
        return buyers.stream().mapToInt(Buyer::getFoodBought).sum();
    }

    private static void processBuying(BufferedReader buffReader, List<Buyer> buyers) throws IOException {
        String line;
        while (!(line = buffReader.readLine()).equals("End")) {
            String name;
            name = line;
            buyers.stream().filter(b -> b.getName().equals(name)).forEach(Buyer::buyFood);
        }
    }

    private static void addBuyers(BufferedReader buffReader, BuyerFactory buyerFactory, List<Buyer> buyers, int n)
            throws IOException {
        for (int i = 0; i < n; i++) {
            String[] params = buffReader.readLine().split("\\s+");
            Buyer buyer = buyerFactory.createBuyer(params);
            buyers.add(buyer);
        }
    }
}
