package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        List<Tuple> tuples = new ArrayList<>();

        tuples.add(getFirstTuple(buffReader));
        tuples.add(getSecondTuple(buffReader));
        tuples.add(getThirdTuple(buffReader));

        for (Tuple tuple : tuples) {
            System.out.println(tuple);
        }
    }

    private static Tuple getFirstTuple(BufferedReader bf) throws IOException {
        String[] line = bf.readLine().split("\\s+");
        String name = line[0] + " " + line[1];
        String adress = line[2];
        return new TupleImpl<>(name, adress);
    }

    private static Tuple getSecondTuple(BufferedReader bf) throws IOException {
        String[] line = bf.readLine().split("\\s+");
        String name  = line[0];
        Integer beerLtrs =  Integer.valueOf(line[1]);
        return new TupleImpl<>(name, beerLtrs);
    }

    private static Tuple getThirdTuple(BufferedReader bf) throws IOException {
        String[] line = bf.readLine().split("\\s+");
        return new TupleImpl<>(Integer.valueOf(line[0]), Double.valueOf(line[1]));
    }
}
