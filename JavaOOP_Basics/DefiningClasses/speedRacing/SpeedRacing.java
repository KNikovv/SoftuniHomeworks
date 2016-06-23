package speedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SpeedRacing {
    static List<Car> carList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int carModels = Integer.parseInt(bf.readLine());

        for(int i=0;i<carModels;i++){
            String[] input = bf.readLine().split("\\s");
            addCars(input);
        }
        String line;
        while(!(line = bf.readLine()).equals("End")){
            String[] input = line.split("\\s");
            tryToDriveCars(input);
        }
        carList.stream().forEach(System.out::println);
    }

    private static void tryToDriveCars(String[] input) {
        String currentCarModel = input[1];
        int wantedDistance = Integer.parseInt(input[2]);
        for(Car car : carList){
            if(car.getCarModel().equals(currentCarModel)){
                car.moveCar(wantedDistance);
            }
        }
    }

    private static void addCars(String[] input){
        String carModel = input[0];
        double fuelAmount = Double.parseDouble(input[1]);
        double fuelCost = Double.parseDouble(input[2]);
        Car currentCar = new Car(carModel,fuelAmount,fuelCost);
        carList.add(currentCar);
    }
}

class Car {
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;
    private String carModel;


    Car(String name, double fuelAmount, double fuelCost) {
        this.setCarModel(name);
        this.setFuelAmount(fuelAmount);
        this.setFuelCost(fuelCost);
        this.setDistanceTraveled(0);
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getCarModel() {
        return this.carModel;
    }

    private void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    private void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return this.fuelCost;
    }

    private void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public  void moveCar(int wantedDistance) {
        double fuelNeeded = wantedDistance * this.getFuelCost();
        if (fuelNeeded <= this.getFuelAmount()) {
            this.setFuelAmount(this.getFuelAmount() - fuelNeeded);
            this.setDistanceTraveled(this.getDistanceTraveled() + wantedDistance);
        }else{
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getCarModel(),this.getFuelAmount(),this.getDistanceTraveled());
    }
}