package rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s");
            String carModel = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoWeight, cargoType);

            ArrayList<Tire> tireList = new ArrayList<Tire>() {{
                add(new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6])));
                add(new Tire(Double.parseDouble(input[7]), Integer.parseInt(input[8])));
                add(new Tire(Double.parseDouble(input[9]), Integer.parseInt(input[10])));
                add(new Tire(Double.parseDouble(input[11]), Integer.parseInt(input[12])));
            }};
            Car car = new Car(carModel, currentEngine, currentCargo, tireList);
            carList.add(car);
        }
        String cargoTypeWanted = bf.readLine();
        carList.stream().filter(car -> {
            switch (cargoTypeWanted) {
                case "fragile":
                    for (Tire tire : car.getTires()) {
                        if(tire.getTirePressure()<1){
                            return true;
                        }
                    }
                case "flamable":
                    return car.getEngine().getPower() > 250 && car.getCargo().getCargoType().equals("flamable");
            }
            return false;
        }).forEach(System.out::println);
    }
}
