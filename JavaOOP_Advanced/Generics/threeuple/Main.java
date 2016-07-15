package threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Threeuple> threeuples = new ArrayList<>();

        threeuples.add(getFirstThreeuple(buffReader));
        threeuples.add(getSecondThreeuple(buffReader));
        threeuples.add(getThirdThreeuple(buffReader));

        for (Threeuple threeuple : threeuples) {
            System.out.println(threeuple);
        }
    }

    private static Threeuple getFirstThreeuple(BufferedReader bf) throws IOException {
        String[] line = bf.readLine().split("\\s+");
        String name = line[0] + " " + line[1];
        String adress = line[2];
        String town = line[3];

        return new ThreeupleImpl<>(name, adress, town);
    }

    private static Threeuple getSecondThreeuple(BufferedReader bf) throws IOException {
        String[] line = bf.readLine().split("\\s+");
        String name = line[0];
        Integer beerLtrs = Integer.valueOf(line[1]);
        boolean drankOrNot = line[2].equals("drunk");

        return new ThreeupleImpl<>(name, beerLtrs, drankOrNot);
    }

    private static Threeuple getThirdThreeuple(BufferedReader bf) throws IOException {
        String[] line = bf.readLine().split("\\s+");
        String name = line[0];
        Double accBalance = Double.valueOf(line[1]);
        String bankName = line[2];

        return new ThreeupleImpl<>(name, accBalance, bankName);
    }
}
